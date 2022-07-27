/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendManagerClasses;

import BackendDatatypes.Student;
import BackendManagerClasses.BookManager;
import Database.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gia Naicker
 */
public class StudentManager {

    private ArrayList<Student> students;
    private ArrayList<String> grades;
    private ArrayList<String> namesFromGrade;
    DB db;

    public StudentManager() throws ClassNotFoundException, SQLException {
        db = new DB();
        students = new ArrayList<>();

        ResultSet rs = db.query("SELECT * FROM students;");

        //acts as a scanner (must add 1 before traversing through ResultSet)
        while (rs.next()) {
            int studentID = rs.getInt(1);
            String firstName = rs.getString(2);
            String surname = rs.getString(3);
            int grade = rs.getInt(4);

            //creates ArrayList of Students...use this arrayList later on
            students.add(new Student(studentID, firstName, surname, grade)); //arrayList has own built-in methods

        }
    }

    //creates an arrayList of grades from 8-12
    public ArrayList<String> getGrades() throws ClassNotFoundException, SQLException {
        grades = new ArrayList<>();
        ResultSet rs = db.query("SELECT DISTINCT grade FROM students ORDER BY grade;");

        while (rs.next()) {
            String grade = rs.getString(1);
            grades.add(grade);
        }
        return grades;
    }

    //adds a new student to the database (studdents table)
    public void addNewStudent(String name, String surname, int grade) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO students (firstName, surname, grade) "
                + "VALUES ('" + name + "','" + surname + "','" + grade + "');";

        db.update(query);

    }

    //removes student from the databse (students table)
    public void deleteBook(int i) throws ClassNotFoundException, SQLException {
        db.update("DELETE FROM students WHERE firstName = '" + students.get(i).getName() + "'\n"
                + "AND surname = '" + students.get(i).getSurname() + "'\n"
                + "AND grade = '" + students.get(i).getGrade() + "';");
        students.remove(i);
        System.out.println("This student has been removed from the database");
    }

    //gets arrayList of students names and surnames
    public ArrayList<String> getStudentsNames() {
        ArrayList<String> names = new ArrayList<>();

        for (Student s : students) {
            names.add(s.getName() + " " + s.getSurname());
        }

        return names;
    }

    //returns names arrayList of students based on grade
    public ArrayList<String> getNamesFromGrade(int gr) throws ClassNotFoundException, SQLException {
        ArrayList<String> namesFromGrade = new ArrayList<>();

        ResultSet rs = db.query("SELECT firstName, surname FROM students WHERE grade = " + gr + ";");

        while (rs.next()) {
            String names = rs.getString(1);
            String surnames = rs.getString(2);
            namesFromGrade.add(names + " " + surnames);
        }
        return namesFromGrade;
    }

    //populating table with student names
    public Object[][] makeStudentTable() {

        Object[][] testTable = new Object[students.size()][3];

        for (int row = 0; row < students.size(); row++) {

            testTable[row][0] = students.get(row).getName();
            testTable[row][1] = students.get(row).getSurname();
            testTable[row][2] = students.get(row).getGrade();
        }

        return testTable;
    }

    public Student setComponentsToEditStudent(int selectedStudentIndex) {
        return students.get(selectedStudentIndex);
    }

    public void updateStudentInformation(int studentID, String name, String surname, int grade) throws ClassNotFoundException, SQLException {
        db.update("UPDATE students\n"
                + "SET firstName = '" + name + "', surname = '" + surname + "', grade = " + grade + "\n"
                + "WHERE studentID = " + studentID + ";");
    }

    public ArrayList<String> populateReturnStudentComboBox() throws ClassNotFoundException, SQLException {
        ArrayList<String> studentsToReturnList = new ArrayList<>();
        ArrayList<String> studentIDs = new ArrayList<>();
        ResultSet rs = db.query("SELECT DISTINCT studentID FROM borrowedbooks;");

        int studentIDresult = 0;
        while (rs.next()) {
            studentIDresult = rs.getInt(1);
            studentIDs.add(String.valueOf(studentIDresult));
        }
        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < studentIDs.size(); j++) {
                if (students.get(i).getStudentID() == Integer.parseInt(studentIDs.get(j))) {
                    studentsToReturnList.add(students.get(i).getName() + " " + students.get(i).getSurname());
                }
            }
        }
        return studentsToReturnList;
    }

    //checks how many times a student has taken out a book and returned it
    public int doesStudentHaveBook(int bookID, int studentID) throws ClassNotFoundException, SQLException {
        int numTakenOut = 0;
        String query1 = "SELECT COUNT(borrowID) from borrowedbooks\n"
                + "WHERE bookID = " + bookID + "\n"
                + "AND studentID = " + studentID + ";";
        System.out.println(query1);
        ResultSet numTakenOutRS = db.query(query1);
        numTakenOutRS.next();
        numTakenOut = numTakenOutRS.getInt(1);

        //Gets the number of times that book has been returned
        int numReturned = 0;
        String query2 = "SELECT COUNT(returnedID) from returnedbooks\n"
                + "WHERE bookID = " + bookID + "\n"
                + "AND studentID = " + studentID + ";";
        System.out.println(query2);
        ResultSet numReturnedRS = db.query(query2);
        while (numReturnedRS.next()) {
            numReturned = numReturnedRS.getInt(1);
        }
        int numStudentReturnedBook = numTakenOut - numReturned;

        return numStudentReturnedBook;
    }

    public ArrayList<String> getStudentsForBook(BookManager bm, String bookName) throws ClassNotFoundException, SQLException {
        ArrayList<String> studentsToReturnList = new ArrayList<>();
        ArrayList<String> studentIDs = new ArrayList<>();
        int bookID = 0;
        for (int i = 0; i < bm.books.size(); i++) {
            if (bm.books.get(i).getTitle().compareToIgnoreCase(bookName) == 0) {
                bookID = bm.books.get(i).getBookID();
            }
        }
        String query = "SELECT DISTINCT studentID FROM borrowedbooks, books\n"
                + "WHERE books.bookID = borrowedbooks.bookID\n"
                + "AND title = '" + bookName + "';";
        System.out.println(query);
        ResultSet rs = db.query(query);

        int studentIDresult = 0;
        while (rs.next()) {
            studentIDresult = rs.getInt(1);
            studentIDs.add(String.valueOf(studentIDresult));
        }
        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < studentIDs.size(); j++) {
                if (students.get(i).getStudentID() == Integer.parseInt(studentIDs.get(j)) && doesStudentHaveBook(bookID, students.get(i).getStudentID()) != 0) {
                    studentsToReturnList.add(students.get(i).getName() + " " + students.get(i).getSurname());

                }
            }
        }
        return studentsToReturnList;
    }

    //Returns the student's studentID based on their name
    public int getStudentIDFromName(String name) {
        int studentID = 0;
        Scanner sc = new Scanner(name);
        String firstName = sc.next();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(firstName)) {
                studentID = students.get(i).getStudentID();
            }
        }
        return studentID;

    }

    @Override
    public String toString() {
        String output = "";
        for (Student s : students) {
            output += s.toString();
        }
        return output;
    }

}
