package models.controllers;

import models.entities.persons.Author;
import models.services.AuthorService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static application.UI.enterToContinue;

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

    public void createAuthor() {
        System.out.println("Let's go register a new author: ");
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter nationality: ");
        String nation = sc.nextLine();
        System.out.print("Enter biography: ");
        String bio = sc.nextLine();
        System.out.println("Enter birth date (dd/mm/yyyy): ");
        String birthdate = sc.nextLine();

        Author a = new Author(name, LocalDate.parse(birthdate, fmt), nation, bio);
        as.newAuthor(a);
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
                count++;
            }

        }
    }

    public void searchAuthors() {
        Author author;

        System.out.print("Enter name of the author: ");
        String name = sc.nextLine();
        author = as.searchAuthor(name);
        if (author != null ) {
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.print(author);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        } else {
            System.out.println("This author is not registered in our library");
            enterToContinue();
        }
    }

    public Author returnSearchAuthors() {
        Author author;

        System.out.print("Enter name of the author: ");
        String name = sc.nextLine();
        author = as.searchAuthor(name);
        if (author != null ) {
            return author;
        } else {
            System.out.println("This author is not registered in our library");
            enterToContinue();
        }

        return null;
    }

    public void editAuthor(Author author) {
        System.out.println("Current Author data");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.print(author);
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println("Note: If you don't want to change anything, just press enter.");
        System.out.print("Enter Author name: ");
        String name = sc.nextLine();

        if (name.length() > 1) {
            author.setName(name);
        }

        System.out.print("Enter the nationality of the author: ");
        String nation = sc.nextLine();

        if (nation.length() > 1) {
            author.setNationality(nation);
        }

        System.out.print("Enter the birth day date of author (dd/mm/yyyy): ");
        String date = sc.nextLine();

        if (!Objects.equals(date, "")) {
            author.setBirthDate(LocalDate.parse(date, fmt));
        }

        System.out.print("Enter the biography of the author: ");
        String bio = sc.nextLine();

        if (bio.length() > 1) {
            author.setBiography(bio);
        }

        as.updateAuthor(author);
        System.out.println("Updated author");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.print(author);
        System.out.println("------------------------------------------------------------------------------------------------------------------");
    }


}
