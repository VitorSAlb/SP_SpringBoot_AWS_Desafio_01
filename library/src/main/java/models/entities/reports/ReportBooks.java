package models.entities.reports;

import models.entities.books.Book;
import models.entities.persons.Author;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReportBooks implements Report{

    private List<Book> books;
    private Book book;

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ReportBooks(List<Book> books) {
        this.books = books;
    }

    public ReportBooks(Book book) {
        this.book = book;
    }

    @Override
    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Report book: \n");
        sb.append("--------------------------\n");
        books.forEach((b) -> sb.append("Book: \n")
                .append("--------------------------\n").append("ISBN: ").append(b.getIsbn()).append(" | Title: ").append(b.getTitle()).append("\n").append("Author: ").append(b.getAuthor().getName()).append(" | Publish Date: ").append(b.getPublishDate().format(fmt)).append("\n").append("Genre: ")
                .append(b.getGender()).append("\n").append("Quantity: ").append(b.getQuantity())
                .append(" | Quantity loans: ").append((b.getQuantityLoans() == null) ?  0 : b.getQuantityLoans()).append("\n").append("--------------------------\n"));

        return sb.toString();
    }
}
