package application;

import models.controllers.AuthorController;
import models.controllers.BookController;
import models.controllers.LoanController;
import models.controllers.MemberController;
import models.entities.books.Book;
import models.entities.persons.Author;
import models.entities.persons.Member;
import models.entities.reports.Report;
import models.entities.reports.ReportLoansMember;
import models.services.AuthorService;
import models.services.BookService;
import models.services.MemberService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class UI {

    private static final BookService bs = new BookService(); // Apagar
    private static final AuthorService as = new AuthorService(); // Apagar
    private static final MemberService ms = new MemberService(); // Apagar

    private static final LoanController lc = new LoanController();
    private static final BookController bc = new BookController();
    private static final AuthorController ac = new AuthorController();
    private static final MemberController mc = new MemberController();

    private static final Scanner sc = new Scanner(System.in);

    private static final DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public UI() {
    }

//    public void testBook(){
//        Book book;
//
//        System.out.println("------- Insert BOOK -------");
//        System.out.println();
//
//        Author author1 = as.searchAuthor("Echiro Oda");
//        Book newBook = new Book(21, "Harry Potter", LocalDate.now(), 2, author1, "sci-fi");
//        bs.newBook(newBook);
//
//        System.out.println();
//        System.out.println("------- END Insert BOOK -------");
//        System.out.println();
//
//        System.out.println("------- Delete BOOK -------");
//        System.out.println();
//
//
//        Author newAuthor = new Author("num sei", LocalDate.now(), "adsd", "dsadas");
//        Book newBookDelete = new Book(22, "Narnia", LocalDate.now(), 2, newAuthor, "fantasia");
//        bs.newBook(newBookDelete);
//        bs.deleteBook(22);
//
//        System.out.println();
//        System.out.println("------- END Delete BOOK -------");
//        System.out.println();
//
//        System.out.println("------- Show BOOK BY ID -------");
//        System.out.println();
//
//        book = bs.searchBook(1);
//        System.out.println(book);
//
//        System.out.println();
//        System.out.println("------- END BOOKS BY ID -------");
//        System.out.println();
//
//        System.out.println("------- Show BOOK NAME -------");
//        System.out.println();
//
//        book = bs.searchBook("Romance Down");
//        System.out.println(book);
//
//        System.out.println();
//        System.out.println("------- END BOOK NAME -------");
//        System.out.println();
//
//        System.out.println("------- Update BOOK -------");
//        System.out.println();
//
//        Author authorToUpdate = new Author("New Author", LocalDate.now(), "USA", "New Bio");
//        newBook = new Book(21, "Harry", LocalDate.now(), 2, authorToUpdate, "sci-fi");
//        bs.updateBook(newBook);
//
//        System.out.println();
//        System.out.println("------- END Update BOOK -------");
//        System.out.println();
//
//        System.out.println("------- Show ALL BOOKS -------");
//        System.out.println();
//        List<Book> booksAll = bs.listBooks();
//
//        for (Book b : booksAll) {
//            System.out.println(b);
//        }
//
//        System.out.println();
//        System.out.println("------- END Show ALL BOOKS -------");
//        System.out.println();
//
//        System.out.println();
//    } // Apagar test
//
//    public void testAuthor(){
//        Author a1 = new Author("Echiro Oda", LocalDate.now(), "Japan", "Made One Piece");
//        Author a2 = new Author("J. K. Rolling", LocalDate.now(), "UK", "Made HP");
//        Author a3 = new Author("Errado", LocalDate.now(), "err", "err");
//        Author a4 = new Author("Deleted", LocalDate.now(), "del", "del");
//        as.newAuthor(a1);
//        as.newAuthor(a2);
//        as.newAuthor(a3);
//        as.newAuthor(a4);
//
//        Author aU = as.searchAuthor("Errado");
//        aU.setBiography("Updated");
//        System.out.println("ID: " + aU.getId());
//        as.updateAuthor(aU);
//        System.out.println(as.searchAuthor("errado"));
//        as.deleteAuthor("Deleted");
//        as.listAuthors();
//    } // Apagar test
//
//    public void testMember() {
//        Member m1 = new Member("Vitor", "vitor@gmail.com", "71996144188", "Salvador", LocalDate.now());
//        Member m2 = new Member("Lis", "Lis@gmail.com", "23132123", "Salvador", LocalDate.now());
//        Member m3 = new Member("Clara", "clara@gmail.com", "3424342", "Salvador", LocalDate.now());
//        Member m4 = new Member("Geo", "geo@gmail.com", "1321231", "Salvador", LocalDate.now());
//        ms.newMember(m1);
//        ms.newMember(m2);
//        ms.newMember(m3);
//        ms.newMember(m4);
//
//        Member mU = ms.searchMember("geo");
//        mU.setName("Carlos");
//        mU.setEmail("carlos@gmail.com");
//        System.out.println(as.searchAuthor("carlos"));
//        ms.deleteMember("Clara");
//        ms.listMembers();
//    } // Apgar teste
//
//    public void testLoan() {
//
//        String dateTime = "10/03/2024 12:00";
//        lc.borrowBook("vitor@gmail.com", 312, LocalDateTime.parse(dateTime, fmt1));
//        lc.borrowBook("lis@gmail.com", 1, LocalDateTime.parse(dateTime, fmt1));
//        lc.borrowBook("carlos@gmail.com", 1, LocalDateTime.now());
//        lc.borrowBook("carlos@gmail.com", 2, LocalDateTime.parse("01/09/2024 12:00", fmt1));
//
//        lc.borrowBook("carlos@gmail.com", 312, LocalDateTime.parse("20/09/2024 12:00", fmt1));
//        lc.borrowBook("carlos@gmail.com", 312, LocalDateTime.parse(dateTime, fmt1));
//        lc.borrowBook("carlos@gmail.com", 312, LocalDateTime.parse(dateTime, fmt1));
//
//
//        lc.returnBook("vitor@gmail.com", 312, LocalDateTime.parse("14/09/2024 12:00", fmt1));
//        lc.returnBook("carlos@gmail.com", 2, LocalDateTime.parse("06/09/2024 12:00", fmt1));
//        lc.returnBook("lis@gmail.com", 1, LocalDateTime.parse("15/09/2024 12:00", fmt1));
//
//        //lc.returnBook("carlos@gmail.com", 2, LocalDateTime.parse("17/03/2024 12:00", fmt1));;
//    } // Apgar test

    public void bannerUI() {
        System.out.println("-------------------------");
        System.out.print("| Albuquerque's Library |\n");
        System.out.println("-------------------------");
        System.out.println();
    }

    public void mainMenu() {
        int option = -1;
        while (option != 0) {
            infiniteSpace();
            bannerUI();

            System.out.println("[1] - Books");
            System.out.println("[2] - Authors");
            System.out.println("[3] - Members");
            System.out.println("[4] - Loans");
            System.out.println("[0] - Exit");
            System.out.print("Enter: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    bookMenu();
                    break;
                case 2:
                    authorMenu();
                    break;
                case 3:
                    memberMenu();
                    break;
                case 4:
                    loanMenu();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    public void bookMenu() {
        int option = -1;
        while (option != 0) {
            infiniteSpace();
            bannerUI();

            System.out.println("[1] - Add Book");
            System.out.println("[2] - List Books");
            System.out.println("[3] - Search book");
            System.out.println("[4] - Edit book");
            System.out.println("[0] - Back");
            System.out.print("Enter: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    infiniteSpace();
                    createBookUI();
                    break;
                case 2:
                    infiniteSpace();
                    listAllBookUI();
                    enterToBack();
                    break;
                case 3:
                    infiniteSpace();
                    searchBookUI();
                    enterToBack();
                    break;
                case 4:
                    infiniteSpace();
                    editBookUI();
                    enterToBack();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    public void authorMenu() {
        int option = -1;
        while (option != 0) {
            infiniteSpace();
            bannerUI();


            System.out.println("[1] - Add author");
            System.out.println("[2] - List Authors");
            System.out.println("[3] - Search author");
            System.out.println("[4] - Edit author");
            System.out.println("[0] - Back");
            System.out.print("Enter: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    infiniteSpace();
                    createAuthorUI();
                    enterToBack();
                    break;
                case 2:
                    infiniteSpace();
                    listAllAuthorsUI();
                    enterToBack();
                    break;
                case 3:
                    infiniteSpace();
                    searchAuthorUI();
                    enterToBack();
                    break;
                case 4:
                    infiniteSpace();
                    editAuthorUI();
                    enterToBack();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    public void memberMenu() {
        int option = -1;
        while (option != 0) {
            infiniteSpace();
            bannerUI();

            System.out.println("[1] - List Members");
            System.out.println("[2] - Search Members");
            System.out.println("[3] - Add Member");
            System.out.println("[4] - Edit Member");
            System.out.println("[0] - Back");
            System.out.print("Enter: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    infiniteSpace();
                    listMemberUI();
                    enterToContinue();
                    break;
                case 2:
                    infiniteSpace();
                    searchMemberUI();
                    enterToContinue();
                    break;
                case 3:
                    infiniteSpace();
                    createMemberUI();
                    enterToContinue();
                    break;
                case 4:
                    infiniteSpace();
                    editMemberUI();
                    enterToContinue();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    public void loanMenu() {
        infiniteSpace();
        bannerUI();

        int option = -1;
        while (option != 0) {
            infiniteSpace();
            bannerUI();

            System.out.println("[1] - List Loans");
            System.out.println("[2] - Borrow Book");
            System.out.println("[3] - Return Book");
            System.out.println("[4] - Report of member");
            System.out.println("[0] - Back");
            System.out.print("Enter: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    infiniteSpace();
                    listLoansUI();
                    enterToContinue();
                    break;
                case 2:
                    infiniteSpace();
                    borrowBookUi();
                    enterToContinue();
                    break;
                case 3:
                    infiniteSpace();
                    returnBookUi();
                    enterToContinue();
                    break;
                case 4:
                    infiniteSpace();
                    reportUI();
                    enterToContinue();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }



// --------------------------------------------------
    public void createBookUI() {
        bc.createBook();
    }

    public void listAllBookUI() {
        bc.listBook();
    }

    public void searchBookUI() {
        bc.searchBook();
    }

    public void editBookUI() {
        Book b = bc.searchBook(true);
        bc.editBook(b);
    }

//------------------------------------------
    public void createAuthorUI() {
    ac.createAuthor();
}

    public void listAllAuthorsUI(){
        ac.listAuthors();
    }

    public void searchAuthorUI() {
        ac.searchAuthors();
    }

    public void editAuthorUI() {
        Author author = ac.returnSearchAuthors();
        ac.editAuthor(author);
    }

//-------------------------------------

    public void createMemberUI() {mc.createMember();}

    public void listMemberUI() { mc.listMembers(); }

    public void searchMemberUI() { mc.searchMember();}

    public void editMemberUI() {
        Member member = mc.returnSearchMember();
        mc.editMember(member);
    }



//-------------------------------------

    public void borrowBookUi() {
        Book b = bc.searchBook(true);
        Member m = mc.returnSearchMember();

        System.out.println("Choose the Date Time: ");
        System.out.println("[1] - Now");
        System.out.println("[2] - Another date time");
        System.out.print("Enter: ");
        int option = sc.nextInt();
        sc.nextLine();

        LocalDateTime loanDateTime = null;

        switch (option) {
            case 1:
                loanDateTime = LocalDateTime.now();
                System.out.println("Date and time set to: " + loanDateTime);
                break;
            case 2:
                System.out.print("Enter date and hours of loan (dd/MM/yyyy HH:mm): ");
                String date = sc.nextLine();

                DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

                try {
                    loanDateTime = LocalDateTime.parse(date, fmt1);
                    System.out.println("Date and time set to: " + loanDateTime);
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format. Please use 'dd/MM/yyyy HH:mm'.");
                    return;
                }
                break;
            default:
                System.out.println("Invalid option, exiting...");
                break;
        }

        lc.borrowBook(m.getEmail(), b.getIsbn(), loanDateTime);
    }

    public void returnBookUi() {
        Book b = bc.searchBook(true);
        Member m = mc.returnSearchMember();

        System.out.println("Choose the Date Time of return: ");
        System.out.println("[1] - Now");
        System.out.println("[2] - Another date time");
        System.out.print("Enter: ");
        int option = sc.nextInt();
        sc.nextLine();

        LocalDateTime loanDateTime = null;

        switch (option) {
            case 1:
                loanDateTime = LocalDateTime.now();
                System.out.println("Date and time set to: " + loanDateTime);
                break;
            case 2:
                System.out.print("Enter date and hours of return (dd/MM/yyyy HH:mm): ");
                String date = sc.nextLine();

                DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

                try {
                    loanDateTime = LocalDateTime.parse(date, fmt1);
                    System.out.println("Date and time set to: " + loanDateTime);
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format. Please use 'dd/MM/yyyy HH:mm'.");
                    return;
                }
                break;
            default:
                System.out.println("Invalid option, exiting...");
                break;
        }

        lc.returnBook(m.getEmail(), b.getIsbn(), loanDateTime);
    }

    public void listLoansUI(){
        lc.listLoans();
    }

    public void reportUI() {
        Member m = mc.returnSearchMember();
        ReportLoansMember rm = new ReportLoansMember(m);
        String report = rm.generateReport();
        System.out.println(report);
    }

//-------------------------------------




    public static void infiniteSpace() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void enterToContinue(){
        System.out.print("Enter to continue...");
        sc.nextLine();
    }

    public static void enterToBack(){
        System.out.print("Enter to back...");
        sc.nextLine();
    }
}
