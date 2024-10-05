package application;

import db.DB;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        DB.connect();

        UI ui = new UI();

        UI.infiniteSpace();
        ui.bannerUI();
        ui.mainMenu();

        DB.disconnect();
    }
}
