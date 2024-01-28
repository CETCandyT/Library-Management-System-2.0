
import java.util.Scanner;
/**
 * Author: Candy Torres
 * Course: Software Development I - CEN 3024C
 * Date: Jan 28 2024
 * Class Name: LibraryManagementSystem
 * Description:Main class that contains the entry point for the LMS.
 * Class demonstrates the functionality of the LMS.
 * Including adding, removing, and listing books.
*/

public class LibraryManagementSystem {
    /**
     * Method: main
     * Purpose: Entry point of the program. Demonstrates LMS functionality.
     * Arguments: String[] args command-line arguments is not used.
     * Return Value: void
     */
    public static void main(String[] args) {

        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // adding initial books
        library.addBook(new Book (1, "To kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book (2, "1984", "George Orwell"));
        library.addBook (new Book (3, "The Great Gatsby" , "F. Scott Fitzgerald" ));

        boolean active = true;

        while (active) {
            System.out.print("Make a selection \n 1. Add a book \n 2. Remove a Book \n 3. List current books \n 4. To exit\n ");
            int userSelection = scanner.nextInt();

            if (userSelection == 1) {
                System.out.print("Please enter a book ID: ");
                int bookId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Please enter a book title: ");
                String bookTitle = scanner.nextLine();
                System.out.print("Please enter the book Author: ");
                String bookAuthor = scanner.nextLine();

                library.addBook(new Book(bookId, bookTitle, bookAuthor));

            } else if (userSelection == 2) {
                System.out.print("Enter the ID of he book to remove: ");
                int removeID = scanner.nextInt();
                library.removeBook(removeID);
            } else if (userSelection == 3) {
                System.out.println("List of all books: ");
                library.listAllBooks();
            } else if (userSelection == 4) {
                active = false;
                System.out.println("Exiting the program.");
            } else{
                System.out.println("Invalid input, please try again");
            }
        }
        scanner.close();
    }
}
