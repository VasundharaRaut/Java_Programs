import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    boolean isAvailable;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
}

public class LibraryManagementSystem {
    private static ArrayList<Book> books = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        books.add(new Book("The Alchemist", "Paulo Coelho"));
        books.add(new Book("Java Programming", "James Gosling"));
        books.add(new Book("Clean Code", "Robert C. Martin"));

        int choice;
        do {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. View Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> viewBooks();
                case 2 -> borrowBook();
                case 3 -> returnBook();
                case 4 -> System.out.println("Thank you for using the Library System.");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void viewBooks() {
        System.out.println("\nAvailable Books:");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.printf("%d. %s by %s [%s]\n", i + 1, book.title, book.author, book.isAvailable ? "Available" : "Borrowed");
        }
    }

    private static void borrowBook() {
        viewBooks();
        System.out.print("Enter the number of the book to borrow: ");
        int bookNumber = sc.nextInt();
        if (bookNumber > 0 && bookNumber <= books.size()) {
            Book book = books.get(bookNumber - 1);
            if (book.isAvailable) {
                book.isAvailable = false;
                System.out.println("You have borrowed "" + book.title + "".");
            } else {
                System.out.println("Sorry, this book is already borrowed.");
            }
        } else {
            System.out.println("Invalid book number.");
        }
    }

    private static void returnBook() {
        viewBooks();
        System.out.print("Enter the number of the book to return: ");
        int bookNumber = sc.nextInt();
        if (bookNumber > 0 && bookNumber <= books.size()) {
            Book book = books.get(bookNumber - 1);
            if (!book.isAvailable) {
                book.isAvailable = true;
                System.out.println("You have returned "" + book.title + "".");
            } else {
                System.out.println("This book was not borrowed.");
            }
        } else {
            System.out.println("Invalid book number.");
        }
    }
}
