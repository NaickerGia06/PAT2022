/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendManagerClasses;

import BackendDatatypes.Student;
import Database.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gia Naicker
 */
public class StudentManager {

    private ArrayList<Student> students;
    private ArrayList<String> grades;
    private ArrayList<String> namesFromGrade;

    public StudentManager() throws ClassNotFoundException, SQLException {
        DB db = new DB();

        students = new ArrayList<>();

        ResultSet rs = db.query("SELECT * FROM students;");

        //acts as a scanner (must add 1 before traversing through ResultSet)
        while (rs.next()) {
            String firstName = rs.getString(2);
            String surname = rs.getString(3);
            int grade = rs.getInt(4);

            //creates ArrayList of Students...use this arrayList later on
            students.add(new Student(firstName, surname, grade)); //arrayList has own built-in methods

        }
    }

    //creates an arrayList of grades from 8-12
    public ArrayList<String> getGrades() throws ClassNotFoundException, SQLException {
        DB db = new DB();
        grades = new ArrayList<>();
        ResultSet rs = db.query("SELECT DISTINCT grade FROM students ORDER BY grade;");

        while (rs.next()) {
            String grade = rs.getString(1);
            grades.add(grade);
        }
        return grades;
    }

    //adds a new student to the database (studdents table)
    public void addNewStudent(Student s) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO tblcandidates (studentID, firstName, surname, grade) "
                + "VALUES ('" + s.getName() + "','" + s.getSurname() + "','" + s.getGrade() + "');";
        DB db = new DB();
        db.query(query);

        //if successful add to the array
        //How to add to arrayList and not array?
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

        DB db = new DB();
        ResultSet rs = db.query("SELECT firstName FROM students WHERE grade = " + "");

        while (rs.next()) {
            String grade = rs.getString(1);
            namesFromGrade.add(grade);
        }
        return namesFromGrade;
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
