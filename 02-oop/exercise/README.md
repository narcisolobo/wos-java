# Exercise: Creating a Simple Library System

Create a simple library system to practice working with classes, fields, methods, constructors, and static members.

## Task 1: Create a Book Class

1.	Define the Class:
  - Create a class named Book.
  - The class should have the following private fields:
  - title (a string representing the book’s title)
  - author (a string representing the author of the book)
  - isbn (a unique identifier for the book)
  - The class should have the following public static field:
  - totalBooks (an integer tracking the total number of Book objects created)
2.	Constructor:
  - Create a constructor that accepts three parameters (title, author, and isbn) and initializes the corresponding fields.
  - In the constructor, increment the totalBooks static field by 1 each time a new Book object is created.
3.	Methods:
  - Create a method getBookInfo() that returns a string with the book’s title, author, and ISBN.
  - Create static methods getTotalBooks() that returns the value of totalBooks.

## Task 2: Create a Library Class

1.	Define the Class:
  - Create a class named Library.
  - The class should have the following private fields:
  - libraryName (a string representing the name of the library)
  - books (an array or ArrayList of Book objects)
2.	Constructor:
  - Create a constructor that accepts one parameter (libraryName) and initializes the corresponding field.
  - Initialize the books array or ArrayList as an empty collection.
3.	Methods:
  - Create a method addBook(Book book) that adds a Book object to the books collection.
  - Create a method getBooks() that returns the list of books in the library.
  - Create a method getLibraryInfo() that returns a string with the library’s name and the number of books it contains.

## Task 3: Testing the Classes

1.	Instantiate Objects:
  - Create several Book objects.
  - Create a Library object and add the books to the library.
2.	Print Information:
  - Use the methods of the Book and Library classes to print information about the books and the library.
  - Print the total number of Book objects created using the getTotalBooks() static method.