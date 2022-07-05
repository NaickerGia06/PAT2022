/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackendDatatypes;

import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author Gia Naicker
 */
public class Book {

    private String title;
    private String authorName;
    private String genre;
    private String ISBN;
    private int quantity;

    public Book(String t, String aN, String g, String isbn, int q) {
        this.title = t;
        this.authorName = aN;
        this.genre = g;
        this.ISBN = isbn;
        this.quantity = q;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        this.title = t;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String aN) {
        this.authorName = aN;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String g) {
        this.genre = g;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String isbn) {
        this.ISBN = isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int q) {
        this.quantity = q;
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", authorName=" + authorName + ", genre=" + genre + ", ISBN=" + ISBN + ", quantity=" + quantity + '}';
    }

}
