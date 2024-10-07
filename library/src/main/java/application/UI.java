package application;

import db.ImportDB;
import exception.InputException;
import models.controllers.*;
import models.entities.Book;
import models.entities.persons.Author;
import models.entities.persons.Member;
import models.entities.reports.ReportBooks;
import models.entities.reports.ReportLoansMember;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UI {

    private static final LoanController lc = new LoanController();
    private static final BookController bc = new BookController();
    private static final AuthorController ac = new AuthorController();
    private static final MemberController mc = new MemberController();

    private static final Scanner sc = new Scanner(System.in);

    public UI() {
    }

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
            System.out.println("[4] - Loans & Reports");
            System.out.println("[5] - Import DataBase");
            System.out.println("[0] - Exit");
            System.out.print("Enter: ");

            try {
                option = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error reading Input. Valid values are from 0 to 5  ");
                clearBuffer();
                enterToContinue();
            }

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
                case 5:
                    importDB();
                    enterToContinue();
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


            try {
                option = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error reading Input. Valid values are from 0 to 4  ");
                clearBuffer();
                enterToContinue();
            }

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

            try {
                option = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error reading Input. Valid values are from 0 to 4  ");
                clearBuffer();
                enterToContinue();
            }

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

            try {
                option = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error reading Input. Valid values are from 0 to 4  ");
                clearBuffer();
                enterToContinue();
            }

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
            System.out.println("[5] - Report of books");
            System.out.println("[0] - Back");
            System.out.print("Enter: ");

            try {
                option = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error reading Input. Valid values are from 0 to 4  ");
                clearBuffer();
                enterToContinue();
            }

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
                case 5:
                    infiniteSpace();
                    reportBooksUI();
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
        try {
            bc.createBook();
        } catch (RuntimeException e) {
            System.out.println("Error create a new book!");
            enterToContinue();
        }
    }

    public void listAllBookUI() {
        bc.listBook();
    }

    public void searchBookUI() {
        bc.searchBook();
    }

    public void editBookUI() {
        Book b = bc.searchBook(true);
        if (b != null ) {
            bc.editBook(b);
        }
    }

//------------------------------------------
    public void createAuthorUI() {
        try {
            ac.createAuthor();
        } catch (RuntimeException e) {
            System.out.println("Error create a new author!");
            enterToContinue();
        }
    }

    public void listAllAuthorsUI(){
        ac.listAuthors();
    }

    public void searchAuthorUI() {
        ac.searchAuthors();
    }

    public void editAuthorUI() {
        Author author = ac.returnSearchAuthors();
        if (author != null) {
            ac.editAuthor(author);
        }
    }

//-------------------------------------

    public void createMemberUI() {
        try {
            mc.createMember();
        } catch (RuntimeException e) {
            System.out.println("Error create a new member!");
            enterToContinue();
        }
    }

    public void listMemberUI() { mc.listMembers(); }

    public void searchMemberUI() { mc.searchMember();}

    public void editMemberUI() {
        Member member = mc.returnSearchMember();
        if (member != null) {
            mc.editMember(member);
        }
    }

//-------------------------------------

    public void borrowBookUi() {
        Book b = bc.searchBook(true);
        Member m = null;
        if (b != null) {
            m = mc.returnSearchMember();
        }


        if (m != null) {
            int option = 0;

            System.out.println("Choose the Date Time: ");
            System.out.println("[1] - Now");
            System.out.println("[2] - Another date time");
            System.out.print("Enter: ");

            try {
                option = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error reading Input. Valid values are from 1 & 2 ");
                clearBuffer();
                enterToContinue();
            }

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
    }

    public void returnBookUi() {
        Book b = bc.searchBook(true);
        Member m = null;

        if (b != null) {
            m = mc.returnSearchMember();
        }

        if (m != null) {
            int option = 0;

            System.out.println("Choose the Date Time of return: ");
            System.out.println("[1] - Now");
            System.out.println("[2] - Another date time");
            System.out.print("Enter: ");

            try {
                option = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error reading Input. Valid values are from 0 to 4  ");
                clearBuffer();
                enterToContinue();
            }

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
    }

    public void listLoansUI(){
        lc.listLoans();
    }

    public void reportUI() {
        Member m = mc.returnSearchMember();
        if(m != null) {
            ReportLoansMember rm = new ReportLoansMember(m);
            String report = rm.generateReport();
            System.out.println(report);
        } else {
            System.out.println("This member not exist!");
        }

    }

    public void reportBooksUI() {
        Book book = bc.searchBook(true);
        ReportBooks rb = new ReportBooks(book);
        try {
            String text = rb.generateReport();
            System.out.println(text);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

//-------------------------------------

    public void importDB() {
        ImportDB idb = new ImportDB();
        idb.importMembers();
        idb.importAuthors();
        idb.importBooks();
    }

    public static void infiniteSpace() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void clearBuffer(){
        sc.nextLine();

    }public static void enterToContinue(){
        System.out.print("Enter to continue...");
        sc.nextLine();
    }

    public static void enterToBack(){
        System.out.print("Enter to back...");
        sc.nextLine();
    }
}
