package models.dao;

import db.DB;
import models.dao.impl.BookDaoJ;

public class DaoFactory {

    public static BookDao createMemberDao() {
        return new BookDaoJ(DB.getEntityManager());
    }
}
