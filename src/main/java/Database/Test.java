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
import java.util.Arrays;
import javax.swing.JTable;

/**
 *
 * @author Gia Naicker
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        StudentManager sm = new StudentManager();
        BookManager bm = new BookManager();
        System.out.println(bm.calcDaysOverdue(sm, "The Knife of Never Letting Go", "Zenya Naicker"));
    }
}
