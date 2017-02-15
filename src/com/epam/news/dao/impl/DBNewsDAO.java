package com.epam.news.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.epam.news.bean.News;
import com.epam.news.dao.connectionpool.ConnectionPool;
import com.epam.news.dao.exception.DAOException;
import com.epam.news.dao.interfaces.NewsDAO;

public class DBNewsDAO implements NewsDAO {

	@Override
	public void addNews(News news) throws DAOException {
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstace().takeConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT `all_news` SET `category` = '" + news.getCategory() + "', `title` = '"
					+ news.getTitle() + "',`author` = '" + news.getAuthor() + "',`year` = '" + news.getYear()
					+ "',`add_info` = '" + "SOME ADD INFO " + "';");
			ConnectionPool.getInstace().dispose();
			System.out.println("News added successfully.");
		} catch (SQLException e) {
			throw new DAOException("News can not be added.", e);
		}
	}

	@Override
	public ArrayList<String> findNews(String searchIn, String searchFor) throws DAOException {

		ArrayList<String> foundedNews = new ArrayList<>();
		Connection connection = null;
		try {
			ResultSet resultSet = null;
			connection = ConnectionPool.getInstace().takeConnection();
			Statement statement = connection.createStatement();
			
			resultSet = statement.executeQuery(
					"SELECT * FROM all_news WHERE " + searchIn.toLowerCase() + " = '" + searchFor.toLowerCase() + "'");
			//System.out.println("SELECT * FROM all_news WHERE " + searchIn.toLowerCase() + " = '" + searchFor.toLowerCase() + "'");
			while (resultSet.next()) {
				String currentResult = "";
				for (int i = 1; i <= 6; i++) {
					currentResult += resultSet.getString(i) + " / ";
				}
				foundedNews.add(currentResult);
			}
		} catch (SQLException e) {
			throw new DAOException("News can not be founded.", e);
		}

		return foundedNews;
	}


	@Override
	public void addNews(String newsToAdd) throws DAOException {
		// writeFile(newsToAdd);
	}

	@Override
	public ArrayList<String> findNews() {
		return null;
	}

}
