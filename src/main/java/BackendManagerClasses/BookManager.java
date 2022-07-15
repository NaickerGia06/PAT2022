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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gia Naicker
 */
public class BookManager {

    public ArrayList<Book> books;
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

    private int getNumBooks(String partialTitle) {
        int count = 0;
        for (Book book : books) {
            if (book.getTitle().contains(partialTitle)) {
                count++;
            }
        }
        return count;
    }

    //populates book table in borrow books based on search function (on key press event)
    public Object[][] makeBooksTable(String partialTitle) {
        Object[][] booksTable = new Object[getNumBooks(partialTitle)][3];

        int currentRow = 0;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().toUpperCase().contains(partialTitle.toUpperCase())) {
                booksTable[currentRow][0] = books.get(i).getTitle();
                booksTable[currentRow][1] = books.get(i).getAuthorName();
                booksTable[currentRow][2] = books.get(i).getQuantity();
                currentRow++;
            }
        }
        return booksTable;
    }

    public Object[][] makeBooksTableForBookManagement() {

        Object[][] manageBooksTable = new Object[books.size()][5];

        for (int row = 0; row < books.size(); row++) {

            manageBooksTable[row][0] = books.get(row).getTitle();
            manageBooksTable[row][1] = books.get(row).getAuthorName();
            manageBooksTable[row][2] = books.get(row).getGenre();
            manageBooksTable[row][3] = books.get(row).getISBN();
            manageBooksTable[row][4] = books.get(row).getQuantity();
        }

        return manageBooksTable;
    }

    //populates borrowBooks table when the program runs
    public Object[][] makeBorrowBooksTableWhenRun() {

        Object[][] borrowBooksTableWhenRun = new Object[books.size()][3];

        for (int row = 0; row < books.size(); row++) {

            borrowBooksTableWhenRun[row][0] = books.get(row).getTitle();
            borrowBooksTableWhenRun[row][1] = books.get(row).getAuthorName();
            borrowBooksTableWhenRun[row][2] = books.get(row).getQuantity();
        }

        return borrowBooksTableWhenRun;
    }

    public void deleteBook(int i) throws ClassNotFoundException, SQLException {
        DB db = new DB();
        db.update("DELETE FROM books WHERE title = '" + books.get(i).getTitle() + "'\n"
                + "AND author = '" + books.get(i).getAuthorName() + "'\n"
                + "AND ISBN = '" + books.get(i).getISBN() + "';");
        books.remove(i);
        System.out.println("This book has been deleted");

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

    //CONVERTS GENRE TO GENREID AND ADDS A NEW BOOK TO THE BOOKS TABLE
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

    //RETURNS A STRING REPRESENTATION OF EVERY BOOK'S FIELDS (INFORMATION)
    public String toString() {
        String out = "";

        for (Book book : books) {
            out += book.toString() + "\n";
        }

        return out;
    }

    //build up this method. First get array list of books, populate table with arrays - Find recommended functions.
    public Object[][] makeBooksFromGenreTable(String gen) throws ClassNotFoundException, SQLException {
        //create an arrayList of books based on genre
        ArrayList<String> booksFromGenre = new ArrayList<>();

        //write SQL Query to join 3 tables and get values
        DB db = new DB();
        ResultSet rs = db.query("SELECT title, author, genres.genre, rating, quantity \n"
                + "FROM books, genres, ratings\n"
                + "WHERE (books.genreID = genres.genreID AND books.bookID = ratings.bookID)"
                + "AND genre = '" + gen + "';");

        String title = "";
        String author = "";
        String genre = "";
        int rating = 0;
        int quantity = 0;

        while (rs.next()) {
            title = rs.getString(1);
            author = rs.getString(2);
            genre = rs.getString(3);
            rating = rs.getInt(4);
            quantity = rs.getInt(5);
        }

        //Make table from values in the arrayList
        Object[][] genreTable = new Object[books.size()][5];

        for (int row = 0; row < books.size(); row++) {
            genreTable[row][0] = title;
            genreTable[row][1] = author;
            genreTable[row][2] = genre;
            genreTable[row][3] = rating;
            genreTable[row][4] = quantity;
        }

        return genreTable;
    }

    //ADDS INFORMATION TO THE BORROWBOOKS TABLE IN DATABASE
    public void addToBorrowedBooksTable(int selectedStringIndex, String studentFullName, LocalDate dateBorrowed) throws ClassNotFoundException, SQLException {
        //Scans fullName to get firstName
        Scanner sc = new Scanner(studentFullName);
        String firstName = sc.next();
        sc.close();

        DB db = new DB();
        ResultSet rs = db.query("SELECT bookID FROM books/n"
                + "WHERE title = '" + books.get(selectedStringIndex).getTitle() + "';");

        int bookID = 0;
        while (rs.next()) {
            bookID = rs.getInt(1);
        }

        String query = "INSERT INTO borrowedBooks (bookID, studentID, dateBorrowed)\n"
                + "VALUES ('" + b.getTitle() + "','" + b.getAuthorName() + "','" + genreID + "','" + b.getISBN() + "','" + b.getQuantity() + "');";

        db.update(query);
        //decrease quantity available by one
    }

}
