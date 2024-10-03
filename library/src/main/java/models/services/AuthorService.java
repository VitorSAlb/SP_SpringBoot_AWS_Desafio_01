package models.services;

import db.DB;
import models.dao.DaoFactory;
import models.dao.impl.AuthorDaoJ;
import models.entities.persons.Author;

import java.util.List;

public class AuthorService {

    private final AuthorDaoJ authorDao = DaoFactory.createAuthorDao();

    public AuthorService() {
    }

    public void newAuthor(Author author) {
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
