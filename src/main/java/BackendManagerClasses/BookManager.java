/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendManagerClasses;

import Database.DB;
import BackendDatatypes.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gia Naicker
 */
public class BookManager {

    private ArrayList<Book> books;
    private ArrayList<String> genres;

    public BookManager() throws ClassNotFoundException, SQLException {
        DB db = new DB();

        books = new ArrayList<>();

        ResultSet rs = db.query("SELECT * FROM books;");

        while (rs.next()) {
            String name = rs.getString(2);
            String author = rs.getString(3);
            String genre = rs.getString(4);
            String ISBN = rs.getString(5);
            int quantity = rs.getInt(6);

            //array list has its own add and sort function
            books.add(new Book(name, author, genre, ISBN, quantity));

        }
    }

    public ArrayList<String> getBookNames() {
        ArrayList<String> titles = new ArrayList<>();

        for (Book b : books) {
            titles.add(b.getTitle());
        }

        return titles;
    }

    public ArrayList<String> getGenres() throws ClassNotFoundException, SQLException {
        DB db = new DB();
        genres = new ArrayList<>();
        ResultSet rs = db.query("SELECT * FROM genres;");

        while (rs.next()) {
            String genre = rs.getString(2);
            genres.add(genre);
        }
        return genres;
    }

    public String toString() {
        String out = "";

        for (Book book : books) {
            out += book.toString() + "\n";
        }

        return out;
    }

    //Method for getting book names based on the genre, author and favourite book selected
}
