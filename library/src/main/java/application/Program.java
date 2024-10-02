package application;

import db.DB;

public class Program {

    public static void main(String[] args) {
        DB.connect();
        System.out.println();

        // Testes implementação LIVRO
        BookTest bt = new BookTest();
        bt.tests();

        DB.disconnect();
    }
}
