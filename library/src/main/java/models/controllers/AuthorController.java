package models.controllers;

import models.entities.books.Book;
import models.entities.persons.Author;
import models.entities.reports.ReportBooks;
import models.services.AuthorService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class AuthorController {

    private static final Scanner sc = new Scanner(System.in);
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static final AuthorService as = new AuthorService();



    public Author createAuthor(String name) {
        System.out.println("The indicated author " + name + " does not exist in our database");
        System.out.println("Let's go register the author: " + name);
        System.out.print("Enter nationality: ");
        String nation = sc.nextLine();
        System.out.print("Enter biography: ");
        String bio = sc.nextLine();
        System.out.println("Enter birth date (dd/mm/yyyy): ");
        String birthdate = sc.nextLine();

        return new Author(name, LocalDate.parse(birthdate, fmt), nation, bio);
    }

    public Author createAuthor() {
        System.out.println("Let's go register a new author: ");
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter nationality: ");
        String nation = sc.nextLine();
        System.out.print("Enter biography: ");
        String bio = sc.nextLine();
        System.out.println("Enter birth date (dd/mm/yyyy): ");
        String birthdate = sc.nextLine();

        return new Author(name, LocalDate.parse(birthdate, fmt), nation, bio);
    }

    public void listAuthors() {
        List<Author> authors = as.listAuthors().stream().sorted().toList();

        if (authors.isEmpty()) {
            System.out.println("No Authors found.");
        } else {
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.println("List of Authors in alphabetical order");
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            int count = 1;
            for (Author a: authors) {
                System.out.println(count + "º - " + a);
                System.out.println();
                count++;
            }

        }
    }



}
