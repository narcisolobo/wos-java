public class Main {
    public static void main(String[] args) {
        Book sorcerersStone = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "1338878921");
        Book solitude = new Book("One Hundred Years of Solitude", "Gabriel Garcia Marquez", "0060883286");

        Library library = new Library("WOS Books");
        library.addBook(solitude);
        library.addBook(sorcerersStone);

        for (Book book : library.getBooks()) {
            System.out.println(book.getBookInfo());
        }

        System.out.println(Book.getTotalBooks());
    }
}
