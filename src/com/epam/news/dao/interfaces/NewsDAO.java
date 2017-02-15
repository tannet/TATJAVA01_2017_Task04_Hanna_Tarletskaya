package com.epam.news.dao.interfaces;

import java.util.ArrayList;

import com.epam.news.bean.News;
import com.epam.news.dao.exception.DAOException;

public interface NewsDAO {
    public void addNews(String newsToAdd) throws DAOException;
    public ArrayList<String> findNews() throws DAOException;

    
    
    public void addNews(News news) throws DAOException;
    //public ArrayList<String> findNews(News news) throws DAOException; ???
    
    public ArrayList<String> findNews(String searchIn, String searchFor) throws DAOException;
}

