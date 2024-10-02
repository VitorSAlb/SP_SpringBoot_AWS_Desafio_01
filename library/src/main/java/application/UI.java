package application;

import models.entities.books.Book;
import models.entities.persons.Author;
import models.services.AuthorService;
import models.services.BookService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UI {

    private static BookService bs = new BookService();
    private static AuthorService as = new AuthorService();
    private static Scanner sc = new Scanner(System.in);
    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public UI() {
    }

    public void testBook(){
        Book book;

        System.out.println("------- Insert BOOK -------");
        System.out.println();

        Author author1 = as.searchAuthor("Echiro Oda");
        Book newBook = new Book(21, "Harry Potter", LocalDate.now(), 2, author1, "sci-fi");
        bs.newBook(newBook);

        System.out.println();
        System.out.println("------- END Insert BOOK -------");
        System.out.println();

        System.out.println("------- Delete BOOK -------");
        System.out.println();


        Author newAuthor = new Author("num sei", LocalDate.now(), "adsd", "dsadas");
        Book newBookDelete = new Book(22, "Narnia", LocalDate.now(), 2, newAuthor, "fantasia");
        bs.newBook(newBookDelete);
        bs.deleteBook(22);

        System.out.println();
        System.out.println("------- END Delete BOOK -------");
        System.out.println();

        System.out.println("------- Show BOOK BY ID -------");
        System.out.println();

        book = bs.searchBook(1);
        System.out.println(book);

        System.out.println();
        System.out.println("------- END BOOKS BY ID -------");
        System.out.println();

        System.out.println("------- Show BOOK NAME -------");
        System.out.println();

        book = bs.searchBook("Romance Down");
        System.out.println(book);

        System.out.println();
        System.out.println("------- END BOOK NAME -------");
        System.out.println();

        System.out.println("------- Update BOOK -------");
        System.out.println();

        Author authorToUpdate = new Author("New Author", LocalDate.now(), "USA", "New Bio");
        newBook = new Book(21, "Harry", LocalDate.now(), 2, authorToUpdate, "sci-fi");
        bs.updateBook(newBook);

        System.out.println();
        System.out.println("------- END Update BOOK -------");
        System.out.println();

        System.out.println("------- Show ALL BOOKS -------");
        System.out.println();
        List<Book> booksAll = bs.listBooks();

        for (Book b : booksAll) {
            System.out.println(b);
        }

        System.out.println();
        System.out.println("------- END Show ALL BOOKS -------");
        System.out.println();

        System.out.println();
    } // Apagar test

    public void testAuthor(){
        Author a1 = new Author("Echiro Oda", LocalDate.now(), "Japan", "Made One Piece");
        Author a2 = new Author("J. K. Rolling", LocalDate.now(), "UK", "Made HP");
        Author a3 = new Author("Errado", LocalDate.now(), "err", "err");
        Author a4 = new Author("Deleted", LocalDate.now(), "del", "del");
        as.newAuthor(a1);
        as.newAuthor(a2);
        as.newAuthor(a3);
        as.newAuthor(a4);

        Author aU = as.searchAuthor("Errado");
        aU.setBiography("Updated");
        System.out.println("ID: " + aU.getId());
        as.updateAuthor(aU);
        System.out.println(as.searchAuthor("errado"));
        as.deleteAuthor("Deleted");
        as.listAuthors();
    } // Apagar test

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
        infiniteSpace();
        bannerUI();

        int option = -1;
        while (option != 0) {
            System.out.println("[1] - Cadastrar book");
            System.out.println("[2] - Lista de books");
            System.out.println("[3] - Pesquisar book");
            System.out.println("[4] - Editar book");
            System.out.println("[5] - Deletar book");
            System.out.println("[6] - Verificar lista book emprestados");
            System.out.println("[7] - Emprestar book");
            System.out.println("[0] - Voltar");
            System.out.print("Enter: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    createBookUI();
                    break;
                case 2:
                    //listBooksUI(); listar livros
                    break;
                case 3:
                    //searchBookUI(); pesquisar livros
                    break;
                case 4:
                    //editBookUi(); editar livros
                    break;
                case 5:
                    //deleteBookUi(); deletar livros
                    break;
                case 6:
                    //checkLoanedBooksUi(); verificar livros emprestados livros
                    break;
                case 7:
                    //loanBook(); emprestar livro
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
        infiniteSpace();
        bannerUI();

        int option = -1;
        while (option != 0) {
            System.out.println("[1] - Add author");
            System.out.println("[2] - Lista de authors");
            System.out.println("[3] - Pesquisar author");
            System.out.println("[4] - Deletar author");
            System.out.println("[5] - Editar author");
            System.out.println("[0] - Voltar");
            System.out.print("Enter: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    createAuthorUI();
                    break;
                case 2:
                    //listAuthorsUI(); lista autores
                    break;
                case 3:
                    //searchAuthorUi(); pesquisar autores
                    break;
                case 4:
                    //deleteAuthorUi(); deletar autor
                    break;
                case 5:
                    //editAuthorUi(); editar autor
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
        infiniteSpace();
        bannerUI();

        int option = -1;
        while (option != 0) {
            System.out.println("[1] - Lista membros");
            System.out.println("[2] - Pesquisar por membros");
            System.out.println("[3] - Deletar membro");
            System.out.println("[4] - Editar membro");
            System.out.println("[5] - Lista de membros com livros");
            System.out.println("[0] - Voltar");
            System.out.print("Enter: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    //listMembers(); listar membros
                    break;
                case 2:
                    //searchMembers(); pesquisar membro
                    break;
                case 3:
                    //deleteMember(); deletar membro
                    break;
                case 4:
                    //editMember(); editar membro
                    break;
                case 5:
                    //listMembersWithBooks(); litar membors com livros
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
            System.out.println("[1] - Lista de livros emprestados");
            System.out.println("[2] - Emprestar livro");
            System.out.println("[3] - Devolver livro");
            System.out.println("[4] - Relatório");
            System.out.println("[0] - Voltar");
            System.out.print("Enter: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    //listLoanedBooksUI(); listar livros emprestados
                    break;
                case 2:
                    //loanBookUi(); emprestar livros
                    break;
                case 3:
                    //returnBook(); devolver livros
                    break;
                case 4:
                    //generateReport(); gerar relatorio
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }




    public void createBookUI() {
        infiniteSpace();

        try {
            System.out.println("Create a new book!");
            System.out.print("Enter book ISBN: ");
            int isbn = sc.nextInt();
            sc.nextLine();
            if (bs.searchBook(isbn) != null) {
                System.out.println("The indicated book already exists");
                enterToContinue();
            }
            System.out.print("Enter book title: ");
            String title = sc.nextLine();
            System.out.print("Enter the author's name: ");
            String name = sc.nextLine();
            Author author = as.searchAuthor(name);
            if (author == null) {
                author = createAuthorUI(name);
                as.newAuthor(author);
            } else {
                System.out.println("The author already exists in the database!");
                enterToContinue();
            }
            System.out.print("Enter the genre of the book: ");
            String gender = sc.nextLine();
            System.out.print("Enter book publish date (dd/mm/yyyy): ");
            String publishDate = sc.nextLine();
            System.out.print("Enter the number of books: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            Book b = new Book(isbn, title, LocalDate.parse(publishDate, fmt), quantity, author, gender);
            bs.newBook(b);
            System.out.println("The book " + title + " is now ready!");
            enterToContinue();

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter the correct value.");
            sc.nextLine();
        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid date format. Please use dd/mm/yyyy.");
            sc.nextLine();
        } catch (RuntimeException e) {
            System.out.println("Unexpected error: " + e.getMessage());
            sc.nextLine();
        }
    }

    public Author createAuthorUI(String name) {
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

    public Author createAuthorUI() {
        infiniteSpace();

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

    public void infiniteSpace() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public void enterToContinue(){
        System.out.print("Enter to continue...");
        sc.nextLine();
    }
}
