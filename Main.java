package FinalProject3;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Library library = new Library();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add a book");
            System.out.println("2. Delete a book");
            System.out.println("3. Register a new reader");
            System.out.println("4. Remove a reader");
            System.out.println("5. Search books by author");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    deleteBook();
                    break;
                case 3:
                    registerReader();
                    break;
                case 4:
                    removeReader();
                    break;
                case 5:
                    searchByAuthor();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook() {
        if (!library.isTherePlaceForNewBook()) {
            System.out.println("No place for new books.");
            return;
        }

        System.out.println("Enter author:");
        String author = scanner.nextLine();
        System.out.println("Enter title:");
        String title = scanner.nextLine();
        System.out.println("Enter number of pages:");
        int numOfPages = scanner.nextInt();
        scanner.nextLine();

        Book newBook = new Book(author, title, numOfPages);
        library.addNewBook(newBook);
    }

    private static void deleteBook() {
        System.out.println("Enter title of the book to delete:");
        String title = scanner.nextLine();
        library.deleteBook(title);
    }

    private static void registerReader() {
        System.out.println("Enter reader ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter reader name:");
        String name = scanner.nextLine();
        library.registerReader(id, name);
    }

    private static void removeReader() {
        System.out.println("Enter reader name to remove:");
        String name = scanner.nextLine();
        library.removeReader(name);
    }

    private static void searchByAuthor() {
        System.out.println("Enter author name:");
        String author = scanner.nextLine();
        List<String> titles = library.searchByAuthor(author);
        if (titles.isEmpty()) {
            System.out.println("No books found for this author.");
        } else {
            System.out.println("Books by " + author + ":");
            for (String title : titles) {
                System.out.println(title);
            }
        }
    }
}
