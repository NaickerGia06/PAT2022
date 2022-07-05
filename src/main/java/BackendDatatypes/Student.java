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

    private String name;
    private String surname;
    private int grade;

    public Student(String n, String s, int g) {
        this.name = n;
        this.surname = s;
        this.grade = g;
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

    public Student() {

    }
}
