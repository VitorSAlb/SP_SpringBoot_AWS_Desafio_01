package application;

import models.controllers.*;
import models.entities.books.Book;
import models.entities.persons.Author;
import models.entities.persons.Member;
import models.entities.reports.ReportLoansMember;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
