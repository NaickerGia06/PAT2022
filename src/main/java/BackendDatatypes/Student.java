/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendDatatypes;

/**
 *
 * @author Gia Naicker
 */
public class Student {

    private int studentID;
    private String name;
    private String surname;
    private int grade;

    public Student(int sID, String n, String s, int g) {
        this.studentID = sID;
        this.name = n;
        this.surname = s;
        this.grade = g;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", name=" + name + ", surname=" + surname + ", grade=" + grade + '}';
    }

}
