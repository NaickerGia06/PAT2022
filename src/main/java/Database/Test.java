/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import BackendManagerClasses.BookManager;
import BackendManagerClasses.StudentManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gia Naicker
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        StudentManager sm = new StudentManager();
        System.out.println(sm.toString());

        //ArrayList<String> g = sm.getGrades();
        //System.out.println(g.toString());
    }
}
