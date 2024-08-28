import java.util.ArrayList;

/*
Create a constructor that accepts one parameter (libraryName) and initializes the corresponding field.
Initialize the books ArrayList as an empty collection.
 */
public class Library {
    private String libraryName;
    private ArrayList<Book> books;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
    }

    // Create a method addBook(Book book) that adds a Book object to the books collection.
    public void addBook(Book book) {
        this.books.add(book);
    }

    // Create a method getBooks() that returns the list of books in the library.
    public ArrayList<Book> getBooks() {
        return this.books;
    }

    // Create a method getLibraryInfo() that returns a string with the library’s name and the number of books it contains.
    public String getLibraryInfo() {
        return String.format("Library name: %s, Book count: %d", this.libraryName, this.books.size());
    }
}
