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

        ResultSet rs = db.query("SELECT title, author, genres.genre, ISBN, quantity\n"
                + "FROM librarydb.books, librarydb.genres\n"
                + "WHERE books.genreID = genres.genreID;");

        while (rs.next()) {
            String name = rs.getString(1);
            String author = rs.getString(2);
            String genre = rs.getString(3);
            String ISBN = rs.getString(4);
            int quantity = rs.getInt(5);

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
        ResultSet rs = db.query("SELECT genre FROM genres;");

        while (rs.next()) {
            String genre = rs.getString(1);
            genres.add(genre);
        }
        return genres;
    }

    //COMPARES GENRE TO GENRE OF BOOK AT A SPECIFIC POSITION IN THE ARRAYLIST
    public ArrayList<String> getBooksFromGenre(String gen) throws ClassNotFoundException, SQLException {
        ArrayList<String> booksFromGenre;
        booksFromGenre = new ArrayList<>();
        DB db = new DB();
        ResultSet rs = db.query("SELECT title\n"
                + "FROM librarydb.books, librarydb.genres\n"
                + "WHERE books.genreID = genres.genreID\n"
                + "AND genres.genre = '" + gen + "';");
        while (rs.next()) {
            String title = rs.getString(1);
            booksFromGenre.add(title);
        }
        return booksFromGenre;
    }

    public void addNewBook(Book b) throws SQLException, ClassNotFoundException {
        DB db = new DB();
        ResultSet rs = db.query("SELECT genreID FROM genres\n"
                + "WHERE genre = '" + b.getGenre() + "';");

        int genreID = 0;
        while (rs.next()) {
            genreID = rs.getInt(1);
        }

        String query = "INSERT INTO books (title, author, genreID, ISBN, quantity) "
                + "VALUES ('" + b.getTitle() + "','" + b.getAuthorName() + "','" + genreID + "','" + b.getISBN() + "','" + b.getQuantity() + "');";

        db.update(query);

    }

    public String toString() {
        String out = "";

        for (Book book : books) {
            out += book.toString() + "\n";
        }

        return out;
    }

    //build up this method. First get array list of books, populate table with arrays
}
