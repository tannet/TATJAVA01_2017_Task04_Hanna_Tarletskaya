package com.epam.news.dao.factory;

import com.epam.news.dao.impl.DBNewsDAO;
import com.epam.news.dao.interfaces.NewsDAO;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final NewsDAO dbNewsImpl = new DBNewsDAO();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public NewsDAO getNewsDAO() {
        return dbNewsImpl;
    }

}
