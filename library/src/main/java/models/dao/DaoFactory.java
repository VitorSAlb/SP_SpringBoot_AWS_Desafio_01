package models.dao;

import db.DB;
import models.dao.impl.AuthorDaoJ;
import models.dao.impl.BookDaoJ;

public class DaoFactory {

    public static BookDaoJ createBookDao() {
        return new BookDaoJ(DB.getEntityManager());
    }

    public static AuthorDaoJ createAuthorDao() {
        return new AuthorDaoJ(DB.getEntityManager());
    }
}
