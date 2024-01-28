import java.util.ArrayList;

/**
 * Author: Candy Torres
 * Course: Software Development I - CEN 3024C
 * Date: Jan 28 2024
 * Class Name: Library
 * Description:Manages a collection of books in the library management system.
 * this class include methods to add, remove and list books.
 */

public class Library {
    //private ArrayList to store books.
    private final ArrayList<Book> books;

    /**
     * Library constructor initializes an empty ArrayList to store books.
     */

    public Library() {
        this.books = new ArrayList<>();

    }

    /**
     * Adds a book to the library collection.
     * @param book The book to be added
     */

    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Removes a book from the library collection based on the ID.
     * @param id the unique ID of the book to be removed.
     */

    public void removeBook(int id) {
        books.removeIf(book -> book.id == id);

    }

    /**
     * lists all the books in the library collection
     */
    public void listAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    /**
     * gets the size of the library
     * @return the number of books in the library.
     */
    public int getLibrarySize() {
        return books.size();
    }
}
