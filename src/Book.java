/**
 * Author: Candy Torres
 * Course: Software Development I - CEN 3024C
 * Date: Jan 28 2024
 * Class Name: Book
 * Description:Represents a book with and ID, title and author.
 * this class is part of the Library Management System(LMS)
 */

public class Book {

    // (book class)
    int id;
    String title;
    String author;

    /**
     * @param id the unique ID of the book
     * @param title The title of the book
     * @param author The author of the book
     */
    public Book(int id, String title, String author){
        this.id = id;
        this.title = title;
        this.author = author;
    }

    /**
     * override of the toString method to provide a string representation of the book.
     * @return a string containing the ID of the book, title and author.
     */
    @Override
    public String toString() {
        return id + "," + title + "," + author;
    }
}
