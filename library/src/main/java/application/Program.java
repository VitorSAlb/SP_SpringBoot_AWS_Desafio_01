package application;

import db.DB;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UI ui = new UI();
        DB.connect();

        UI.infiniteSpace();
        ui.bannerUI();
        ui.mainMenu();

        sc.close();
        DB.disconnect();
    }
}
