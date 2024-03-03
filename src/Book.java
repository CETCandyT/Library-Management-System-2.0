import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Author: Candy Torres
 * Course: Software Development I - CEN 3024C
 * Date: March 3, 2024
 * Class Name: Book
 * Description: Represents a book with an ID, title, author,
 * barcode, availability, checkout date, and due date.
 */
public class Book {
    // Fields
    private final int id;
    private final String title;
    private final String author;
    private final String barcode;
    private boolean available;
    private LocalDate dueDate;
    private LocalDate checkoutDate;

    // Constructor
    public Book(int id, String title, String author, String barcode, boolean available, LocalDate dueDate, LocalDate checkoutDate) {

        this.id = id;
        this.title = title;
        this.author = author;
        this.barcode = barcode;
        this.available = available;
        this.dueDate = dueDate;
        this.checkoutDate = checkoutDate;
    }

    // Getters
    public String getBarcode() {
        return barcode;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getId() {
        return id;
    }

    // Utility methods

    /**
     * Convert the book data to a string format suitable for saving to a file.
     *
     * @return The book data as a formatted string.
     */
    public String toFileString() {
        return id + "," + title + "," + author + "," + barcode + "," + available + "," + (dueDate != null ? dueDate.toString() : "null");
    }

    // Inside the Book class

    @Override
    public String toString() {
        return "Book [Book ID: " + id + ", Barcode Number: " + barcode + ", Title: " + title + ", Author: " + author + "]";
    }
    // Static method to load books from file

    /**
     * Load books from a file.
     * @param fileName The name of the file containing book data.
     * @return An ArrayList containing the loaded books.
     */
    public static ArrayList<Book> loadBooksFromFile(String fileName) {
        ArrayList<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length != 6) {
                    // Handle incorrect data format
                    continue;
                }
                int id = Integer.parseInt(data[0]);
                String title = data[1];
                String author = data[2];
                String barcode = data[3];
                boolean available = Boolean.parseBoolean(data[4]);
                LocalDate dueDate = data[5].equals("null") ? null : LocalDate.parse(data[5]);

                // Create and add the book to the list
                Book book = new Book(id, title, author, barcode, available, dueDate, null); // Set checkout date as null
                books.add(book);
            }
        } catch (IOException e) {
            // Handle file IO exception
            e.printStackTrace();
        }
        return books;
    }
}
