/*
Create a method getBookInfo() that returns a string with the book’s title, author, and ISBN.
Create static method getTotalBooks() that returns the value of totalBooks.
*/

public class Book {
    private String title;
    private String author;
    private String isbn;

    private static int totalBooks;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        totalBooks++;
    }

    public String getBookInfo() {
        return String.format("Title: %s, Author: %s, ISBN: %s", this.title, this.author, this.isbn);
    }

    public static int getTotalBooks() {
        return Book.totalBooks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
