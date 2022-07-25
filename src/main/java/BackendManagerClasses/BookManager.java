/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendManagerClasses;

import Database.DB;
import BackendDatatypes.Book;
import java.sql.Date;
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
    ArrayList<Book> booksToReturn = new ArrayList<>();
    ArrayList<Book> booksFromGenre = new ArrayList<>();
    StudentManager sm;
    DB db;

    public BookManager() throws ClassNotFoundException, SQLException {
        this.db = new DB();

        books = new ArrayList<>();
        sm = new StudentManager();

        ResultSet rs = db.query("SELECT bookID, title, author, genres.genre, ISBN, quantity\n"
                + "FROM librarydb.books, librarydb.genres\n"
                + "WHERE books.genreID = genres.genreID;");

        while (rs.next()) {
            int bookID = rs.getInt(1);
            String title = rs.getString(2);
            String author = rs.getString(3);
            String genre = rs.getString(4);
            String ISBN = rs.getString(5);
            int quantity = rs.getInt(6);

            //array list has its own add and sort function
            books.add(new Book(bookID, title, author, genre, ISBN, quantity));

        }
    }

    //makes an ArrayList of all genres in the database
    public ArrayList<String> getGenres() throws ClassNotFoundException, SQLException {
        genres = new ArrayList<>();
        ResultSet rs = db.query("SELECT genre FROM genres;");

        while (rs.next()) {
            String genre = rs.getString(1);
            genres.add(genre);
        }
        return genres;
    }

    //The method of how a table is formed was adapted from Karina Krishnaswamy's 2021 PAT found on Github
    public Object[][] makeManageBooksTable() throws ClassNotFoundException, SQLException {

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

    //helper method for borrowedBooksTable (gets number of books containing that string)
    private int getNumBooksTitle(String partialTitle) {
        int count = 0;
        for (Book book : books) {
            if (book.getTitle().contains(partialTitle)) {
                count++;
            }
        }
        return count;
    }

    private int getNumBooksAuthor(String partialTitle) {
        int count = 0;
        for (Book book : books) {
            if (book.getAuthorName().contains(partialTitle)) {
                count++;
            }
        }
        return count;
    }

    private int getNumBooksGenre(String genre) {
        int count = 0;
        for (Book book : books) {
            if (book.getAuthorName().equalsIgnoreCase(genre)) {
                count++;
            }
        }
        return count;
    }

    //populates book table in borrow books based on search function (on key press event)
    public Object[][] makeBorrowedBooksTable(String partialTitle) throws ClassNotFoundException, SQLException {
        Object[][] booksTable = new Object[getNumBooksTitle(partialTitle)][3];

        int currentRow = 0;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().toUpperCase().contains(partialTitle.toUpperCase())) {
                booksTable[currentRow][0] = books.get(i).getTitle();
                booksTable[currentRow][1] = books.get(i).getAuthorName();
                booksTable[currentRow][2] = getNumAvailableBook(books.get(currentRow).getBookID());
                currentRow++;
            }
        }
        return booksTable;
    }

    //Gets information from an SQL query and returns a 2D object array of books that have been borrowed to populate the return books table
    public Object[][] makeReturnBooksTable() throws ClassNotFoundException, SQLException {

        ArrayList<String> bookIDs = new ArrayList<>();

        ResultSet rs = db.query("SELECT DISTINCT bookID FROM borrowedBooks;");

        int bookID = 0;
        while (rs.next()) {
            bookID = rs.getInt(1);
            bookIDs.add(String.valueOf(bookID));
        }

        for (int i = 0; i < books.size(); i++) {
            for (int j = 0; j < bookIDs.size(); j++) {
                if (books.get(i).getBookID() == Integer.parseInt(bookIDs.get(j))) {
                    booksToReturn.add(books.get(i));
                }
            }
        }

        Object[][] returnBooksTable = new Object[booksToReturn.size()][2];
        for (int row = 0; row < booksToReturn.size(); row++) {
            returnBooksTable[row][0] = booksToReturn.get(row).getTitle();
            returnBooksTable[row][1] = booksToReturn.get(row).getAuthorName();
        }

        return returnBooksTable;
    }

    //Gets an index as a parameter and sends a query to the database to remove the book from the books ArrayList and bookstable
    public void deleteBook(int i) throws ClassNotFoundException, SQLException {
        db.update("DELETE FROM books WHERE title = '" + books.get(i).getTitle() + "'\n"
                + "AND author = '" + books.get(i).getAuthorName() + "'\n"
                + "AND ISBN = '" + books.get(i).getISBN() + "';");
        books.remove(i);
        System.out.println("This book has been deleted");

    }

    //Adds a new book to the database
    public void addNewBook(String title, String author, String genre, String ISBN, int quantity) throws SQLException, ClassNotFoundException {
        ResultSet rs = db.query("SELECT genreID FROM genres\n"
                + "WHERE genre = '" + genre + "';");

        int genreID = 0;
        while (rs.next()) {
            genreID = rs.getInt(1);
        }

        String query = "INSERT INTO books (title, author, genreID, ISBN, quantity) "
                + "VALUES ('" + title + "','" + author + "','" + genreID + "','" + ISBN + "','" + quantity + "');";

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

    private ArrayList<Book> getBooksFromGenre(String gen) throws ClassNotFoundException, SQLException {

        Object[][] booksFromGenreTable = new Object[getNumBooksTitle(gen)][3];

        for (int i = 0; i < books.size(); i++) {
            if (gen.compareToIgnoreCase(books.get(i).getGenre()) == 0) {
                booksFromGenre.add(books.get(i));
            }
        }
        return booksFromGenre;
    }

    //build up this method. First get array list of books, populate table with arrays - Find recommended functions.
    public Object[][] makeBooksFromGenreTable(String gen) throws ClassNotFoundException, SQLException {
        getBooksFromGenre(gen);
        //Make table from values in the arrayList
        Object[][] genreTable = new Object[booksFromGenre.size()][5];

        for (int row = 0; row < booksFromGenre.size(); row++) {
            genreTable[row][0] = booksFromGenre.get(row).getTitle();
            genreTable[row][1] = booksFromGenre.get(row).getAuthorName();
            genreTable[row][2] = booksFromGenre.get(row).getGenre();
            genreTable[row][3] = getAverageRating(booksFromGenre.get(row).getBookID());
            genreTable[row][4] = getNumAvailableBook(booksFromGenre.get(row).getBookID());
        }

        return genreTable;
    }

    //ADDS INFORMATION TO THE BORROWBOOKS TABLE IN DATABASE
    public void addToBorrowedBooksTable(String selectedBookTitle, String studentFullName, LocalDate dateBorrowed) throws ClassNotFoundException, SQLException {
        //Scans fullName to get firstName
        Scanner sc = new Scanner(studentFullName);
        String firstName = sc.next();
        sc.close();

        DB db = new DB();
        ResultSet bookRS = db.query("SELECT bookID FROM books\n"
                + "WHERE title = '" + selectedBookTitle + "';");
        int bookID = 0;
        while (bookRS.next()) {
            bookID = bookRS.getInt(1);
        }
        ResultSet studentRS = db.query("SELECT studentID FROM students\n"
                + "WHERE firstName = '" + firstName + "';");
        int studentID = 0;
        while (studentRS.next()) {
            studentID = studentRS.getInt(1);
        }

        String query = "INSERT INTO borrowedBooks (bookID, studentID, dateBorrowed)\n"
                + "VALUES ('" + bookID + "','" + studentID + "','" + dateBorrowed + "');";

        db.update(query);
        //DON'T FORGET TO decrease quantity available by one
    }

    public Book setComponentsToEditBook(int selectedBookIndex) {
        return books.get(selectedBookIndex);
    }

    public void updateBookInformation(int bookID, String title, String author, int genreID, String ISBN, int quantity) throws ClassNotFoundException, SQLException {
        db.update("UPDATE books\n"
                + "SET title = '" + title + "', author = '" + author + "', genreID = '" + genreID + "', ISBN = '" + ISBN + "', quantity = " + quantity + "\n"
                + "WHERE bookID = " + bookID + ";");
    }

    //Gets the number of available books to borrow in the library
    public int getNumAvailableBook(int bookID) throws ClassNotFoundException, SQLException {
        //Gets the actual quantity of books from the books table
        int quantity = 0;
        ResultSet quantityRS = db.query("SELECT quantity FROM books WHERE bookID = " + bookID + ";");
        while (quantityRS.next()) {
            quantity = quantityRS.getInt(1);
        }

        //Gets the number of times that book has been takenOut
        int numTakenOut = 0;
        ResultSet numTakenOutRS = db.query("SELECT COUNT(borrowID) from borrowedbooks\n"
                + "WHERE bookID = " + bookID + ";");
        while (numTakenOutRS.next()) {
            numTakenOut = numTakenOutRS.getInt(1);
        }

        //Gets the number of times that book has been returned
        int numReturned = 0;
        ResultSet numReturnedRS = db.query("SELECT COUNT(returnedID) from returnedBooks\n"
                + "WHERE bookID = " + bookID + ";");
        while (numReturnedRS.next()) {
            numReturned = numReturnedRS.getInt(1);
        }
        int numAvail = quantity - numTakenOut + numReturned;

        return numAvail;
    }

    //calculates the average rating on each book in the library
    public double getAverageRating(int bookID) throws ClassNotFoundException, SQLException {
        ResultSet averageRatingRS = db.query("SELECT AVG(rating) FROM ratings WHERE bookID = " + bookID);
        double averageRating = 0.0;

        while (averageRatingRS.next()) {
            averageRating = averageRatingRS.getDouble(1);
        }

        return averageRating;
    }

    public Object[][] makeExploreTableFromSearchingByTitle(String partialTitle) throws ClassNotFoundException, SQLException {
        Object[][] exploreBooksTable = new Object[getNumBooksTitle(partialTitle)][5];

        int currentRow = 0;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().contains(partialTitle)) {
                exploreBooksTable[currentRow][0] = books.get(i).getTitle();
                exploreBooksTable[currentRow][1] = books.get(i).getAuthorName();
                exploreBooksTable[currentRow][2] = books.get(i).getGenre();
                exploreBooksTable[currentRow][3] = getAverageRating(books.get(i).getBookID());
                exploreBooksTable[currentRow][4] = getNumAvailableBook(books.get(currentRow).getBookID());
                currentRow++;
            }
        }
        return exploreBooksTable;
    }

    public Object[][] makeExploreTableFromSearchingByAuthor(String partialTitle) throws ClassNotFoundException, SQLException {
        Object[][] exploreBooksTable = new Object[getNumBooksAuthor(partialTitle)][5];

        int currentRow = 0;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getAuthorName().contains(partialTitle)) {
                exploreBooksTable[currentRow][0] = books.get(i).getTitle();
                exploreBooksTable[currentRow][1] = books.get(i).getAuthorName();
                exploreBooksTable[currentRow][2] = books.get(i).getGenre();
                exploreBooksTable[currentRow][3] = getAverageRating(books.get(i).getBookID());
                exploreBooksTable[currentRow][4] = getNumAvailableBook(books.get(currentRow).getBookID());
                currentRow++;
            }
        }
        return exploreBooksTable;
    }

    public String getHighestRatedBooks() throws ClassNotFoundException, SQLException {
        String output = "";

        ResultSet rs = db.query("SELECT books.title FROM books, ratings\n"
                + "WHERE (books.bookID = ratings.bookID)\n"
                + "AND (rating BETWEEN 4 AND 5);");
        while (rs.next()) {
            String title = rs.getString(1);
            output += title + "\n";
        }
        return output;
    }

    public String getCommentOnASpecificBook(String title) throws ClassNotFoundException, SQLException {
        ResultSet rs = db.query("SELECT ratings.comment, students.firstName FROM books, students, ratings\n"
                + "WHERE (books.bookID = ratings.bookID AND students.studentID = ratings.studentID)\n"
                + "AND (title = '" + title + "');");

        String comment = "";
        String student = "";
        String output = "";

        while (rs.next()) {
            comment = rs.getString(1);
            student = rs.getString(2);
            output += comment + " ~ " + student + "\n\n";
        }

        return output;
    }

    //Takes in the title of the book, student and date it was returned and adds the record to the returnedbookstable in database
    public void returnBook(String title, String studentFullName, Date dateReturned) throws ClassNotFoundException, SQLException {
        int studentID = sm.getStudentIDFromName(studentFullName);
        int bookID = getBookIDFromTitle(title);

        db.update("INSERT INTO returnedBooks (bookID, studentID, dateReturned)\n"
                + "VALUES(" + bookID + "," + studentID + ", '" + dateReturned + "');");
    }

    //Returns the book's bookID based on its title
    private int getBookIDFromTitle(String title) {
        int bookID = 0;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                bookID = books.get(i).getBookID();
            }
        }
        return bookID;
    }

    //calculates the fine on overdue books based on the studentID and bookID of the record, returns a double as the amount due
    public double calcOverdueBook(String title, String name) throws ClassNotFoundException, SQLException {
        double fine = 0.00;

        int bookID = getBookIDFromTitle(title);
        int studentID = sm.getStudentIDFromName(name);

        ResultSet rs = db.query("SELECT dateBorrowed FROM borrowedBooks\n"
                + "WHERE bookID = " + bookID + "\n"
                + "AND studentID = " + studentID + ";"); //overdue books are R5 per day it is overdue
        rs.next();

        //rs does not have a LocalDate function and I was unable to convert a date to LocalDate so I used the Date class instead
        Date dateBorrowed = rs.getDate(1);
        System.out.println(dateBorrowed);
        return 0.00;
    }

}
