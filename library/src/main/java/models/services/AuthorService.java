package models.services;

import db.DB;
import exception.DefaultException;
import models.dao.DaoFactory;
import models.dao.impl.AuthorDaoJ;
import models.entities.persons.Author;

import java.util.List;
import java.util.Objects;

public class AuthorService {

    private final AuthorDaoJ authorDao = DaoFactory.createAuthorDao();

    public AuthorService() {
    }

    public void newAuthor(Author author) {

        Author a = searchAuthor(author.getName());
        if (a != null) {
            throw new DefaultException("Author: " + a.getName() + " already exists!");
        }

        authorDao.insert(author);
    }

    public void updateAuthor(Author author) {
        authorDao.update(author);
    }

    public void deleteAuthor(String name){
        authorDao.deleteByName(name);
    }

    public Author searchAuthor(Integer id) {
        return authorDao.findById(id);
    }

    public Author searchAuthor(String name) {
        return authorDao.findByName(name);
    }

    public List<Author> listAuthors() {
        return authorDao.findAll();
    }

}
