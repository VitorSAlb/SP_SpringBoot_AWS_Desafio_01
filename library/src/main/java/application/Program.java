package application;

import db.DB;
import models.services.AuthorService;
import models.services.BookService;

import java.util.Scanner;

public class Program {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DB.connect();

        UI ui = new UI();
        AuthorService as = new AuthorService();
        BookService bs = new BookService();

//        ui.infiniteSpace();
//        ui.bannerUI();
//        ui.mainMenu();

        ui.testMember();
        //ui.createBookUI();


        DB.disconnect();
    }
}
