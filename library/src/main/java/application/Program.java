package application;

import db.DB;
import models.entities.persons.Member;
import models.entities.reports.ReportLoansMember;
import models.services.AuthorService;
import models.services.BookService;
import models.services.MemberService;

import java.util.Scanner;

public class Program {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DB.connect();

        UI ui = new UI();
        AuthorService as = new AuthorService();
        BookService bs = new BookService();
        MemberService ms = new MemberService();

        ui.infiniteSpace();
        ui.bannerUI();
        ui.mainMenu();

        //ui.testMember();
        //ui.createBookUI();

        //ui.testLoan();

        // Report de todos os livros
//        List<Book> books = bs.listBooks();
//        ReportBooks rb = new ReportBooks(books);
//        String allReport = rb.generateReport();
//        System.out.println(allReport);
//
//        //Report de um livro so
//        Book book = bs.searchBook(312);
//        String report = rb.generateReport();
//        System.out.println(report);

        //Report de um member
//        Member member = ms.searchMember("carlos@gmail.com");
//        ReportLoansMember rm = new ReportLoansMember(member);
//        String report = rm.generateReport();
//        System.out.println(report);

        DB.disconnect();
    }
}
