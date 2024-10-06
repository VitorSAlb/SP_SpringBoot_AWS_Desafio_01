package models.controllers;


import application.UI;
import exception.DefaultException;
import models.entities.Book;
import models.entities.persons.Author;
import models.services.AuthorService;
import models.services.BookService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static application.UI.enterToContinue;
import static application.UI.infiniteSpace;

public class BookController {

    private final BookService bs = new BookService();
    private final AuthorService as = new AuthorService();

    private static final AuthorController ac = new AuthorController();

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static final Scanner sc = new Scanner(System.in);

    public void createBook() {
        try {
            System.out.println("Create a new book!");
            System.out.print("Enter book ISBN: ");
            int isbn = sc.nextInt();
            sc.nextLine();
            if (bs.searchBook(isbn) != null) {
                throw new DefaultException("The indicated book already exists");
            }
            System.out.print("Enter book title: ");
            String title = sc.nextLine();
            System.out.print("Enter the author's name: ");
            String name = sc.nextLine();
            Author author = as.searchAuthor(name);
            if (author == null) {
                author = ac.createAuthor(name);
                as.newAuthor(author);
            } else {
                System.out.println("The author already exists in the database!");
                enterToContinue();
            }
            System.out.print("Enter the genre of the book: ");
            String gender = sc.nextLine();
            System.out.print("Enter book publish date (dd/mm/yyyy): ");
            String publishDate = sc.nextLine();
            System.out.print("Enter the number of books: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            Book b = new Book(isbn, title, LocalDate.parse(publishDate, fmt), quantity, author, gender);
            bs.newBook(b);
            System.out.println("The book " + title + " is now ready!");
            enterToContinue();

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter the correct value.");
            sc.nextLine();
            UI.enterToContinue();
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use dd/mm/yyyy.");
            sc.nextLine();
            UI.enterToContinue();
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
            enterToContinue();
            System.out.println();
        }
    }

    public void listBook() {
        List<Book> books = bs.listBooks().stream().sorted().toList();

        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.println("List of books in alphabetical order");
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            int count = 1;
            for (Book b: books) {
                System.out.println(count + "º - " + b);
                System.out.println();
                count++;
            }

        }
    }

    public void searchBook() {
        int option = -1;
        Book book;

        while (option != 3) {
            infiniteSpace();
            System.out.println("What research method do you want to use for the book? (ISBN/title)");
            System.out.println("[1] - ISBN");
            System.out.println("[2] - Title");
            System.out.println("[3] - Exit Search");
            System.out.print("Enter: ");

            try {
                option = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error reading Input. Valid values are from 1 to 3  ");
                enterToContinue();
            }


            switch (option) {
                case 1:
                    System.out.print("Enter ISBN number: ");
                    int isbn = sc.nextInt();
                    sc.nextLine();
                    book = bs.searchBook(isbn);
                    if (book != null) {
                        System.out.println("------------------------------------------------------------------------------------------------------------------");
                        System.out.println(book);
                        System.out.println("------------------------------------------------------------------------------------------------------------------");
                    } else {
                        System.out.println("This book ISBN is not available in our library");
                        enterToContinue();
                    }
                    break;
                case 2:
                    System.out.print("Enter title of the book: ");
                    String title = sc.nextLine();
                    book = bs.searchBook(title);
                    if (book != null ) {
                        System.out.println("------------------------------------------------------------------------------------------------------------------");
                        System.out.println(book);
                        System.out.println("------------------------------------------------------------------------------------------------------------------");
                    } else {
                        System.out.println("This book title is not available in our library");
                        enterToContinue();
                    }

                    break;
                case 3:
                    System.out.println("Exiting search...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    sc.nextLine();
                    break;
            }
        }
    }

    public Book searchBook(Boolean b) {
        int option = -1;
        Book book;

        while (option != 3) {
            UI.infiniteSpace();
            System.out.println("What research method do you want to use for the book? (ISBN/title)");
            System.out.println("[1] - ISBN");
            System.out.println("[2] - Title");
            System.out.println("[3] - Exit Search");
            System.out.print("Enter: ");

            try {
                option = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error reading Input. Valid values are from 1 to 3  ");
                enterToContinue();
            }

            switch (option) {
                case 1:
                    System.out.print("Enter ISBN number: ");
                    int isbn = sc.nextInt();
                    sc.nextLine();
                    book = bs.searchBook(isbn);
                    if (book != null) {
                        b = false;
                        return book;
                    } else {
                        System.out.println("This book ISBN is not available in our library");
                        enterToContinue();
                    }
                    break;
                case 2:
                    System.out.print("Enter title of the book: ");
                    String title = sc.nextLine();
                    book = bs.searchBook(title);
                    if (book != null ) {
                        b = false;
                        return book;
                    } else {
                        System.out.println("This book title is not available in our library");
                        enterToContinue();
                    }

                    break;
                case 3:
                    System.out.println("Exiting search...");
                    return null;
                default:
                    System.out.println("Invalid option. Please try again.");
                    sc.nextLine();
                    break;
            }
        }
        return null;
    }

    public void editBook(Book book) {
        System.out.println("Current book data");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println(book);
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println("Note: If you don't want to change anything, just press enter.");
        System.out.print("Enter book title: ");
        String title = sc.nextLine();

        if (!title.isEmpty()) {
            book.setTitle(title);
        }

        System.out.print("Enter the author's name: ");
        String name = sc.nextLine();

        if (name == null) {
            Author author = as.searchAuthor(name);
            if (author == null) {
                author = ac.createAuthor(name);
                as.newAuthor(author);
                book.setAuthor(author);
            } else {
                System.out.println("The author already exists in the database!");
                enterToContinue();
                book.setAuthor(author);
            }
        }

        System.out.print("Enter the genre of the book: ");
        String gender = sc.nextLine();

        if (!gender.isEmpty()) {
            book.setGender(gender);
        }

        System.out.print("Enter book publish date (dd/mm/yyyy): ");
        String publishDate = sc.nextLine();

        if (!Objects.equals(publishDate, "")) {
            book.setPublishDate(LocalDate.parse(publishDate, fmt));
        }

        System.out.print("How many books do you want to add? If you don't want to add any, enter 0: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        book.setQuantity(book.getQuantity() + quantity);

        bs.updateBook(book);
        System.out.println("Updated book");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println(book);
        System.out.println("------------------------------------------------------------------------------------------------------------------");
    }

}
