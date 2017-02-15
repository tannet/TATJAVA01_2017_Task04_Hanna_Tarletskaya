package com.epam.news.service.impl;

import java.util.ArrayList;
import java.util.Scanner;

import com.epam.news.bean.Book;
import com.epam.news.bean.Disk;
import com.epam.news.bean.Film;
import com.epam.news.bean.News;
import com.epam.news.dao.exception.DAOException;
import com.epam.news.dao.factory.DAOFactory;
import com.epam.news.service.Validator;
import com.epam.news.service.exception.ServiceException;
import com.epam.news.service.interfaces.PortalService;

public class PortalServiceImpl implements PortalService {
	private final static String CATEGORY_PATTERN = "Category";
	private final static String TITLE_PATTERN = "Title";
	private final static String AUTHOR_PATTERN = "Author";
	private final static String YEAR_PATTERN = "Year";
	
	private final static String BOOK_PATTERN = "Book";
	private final static String FILM_PATTERN = "Film";
	private final static String DISK_PATTERN = "Disk";
	
	
	private Scanner sc;

	@Override
	public void addNews(String newsToAdd) throws ServiceException {
		if (!Validator.isNewsToAddValid(newsToAdd)) {
			System.out.println("News to add is invalid. Please check your parameters.");
		} else if (Validator.isCategoryValid(newsToAdd.split(" / ")[0])) {
			News addingNews = new News(newsToAdd); // initialized by same
													// parameters for all
													// categories
			initializeOneNews(newsToAdd, addingNews); // initialized by
														// additional info for
														// choosen categories
			// initializeNews(newsToAdd);
			try {
				// DAOFactory.getInstance().getNewsDAO().addNews(newsToAdd); -
				// for file
				DAOFactory.getInstance().getNewsDAO().addNews(addingNews); // calling
																			// DB
																			// method
			} catch (DAOException e) {
				throw new ServiceException(e);
			}
		} else {
			System.out.println("There is no such type of category. Please check your parameters.");
		}
	}

	@Override
	public void findNews(String newsToFind) throws ServiceException {
		sc = new Scanner(System.in);
		String searchIn = newsToFind.split(" ")[0];
		String searchFor = "";
		System.out.println("Searching in column: " + searchIn + ". Enter the " + searchIn + " in valid format.");
		if (searchIn.equals(CATEGORY_PATTERN) || searchIn.equals(TITLE_PATTERN) || searchIn.equals(AUTHOR_PATTERN)) {
			searchFor = sc.nextLine();
			try {
				ArrayList<String> s = DAOFactory.getInstance().getNewsDAO().findNews(searchIn, searchFor);
				if (s.isEmpty()) {
					System.out.println("There is no such element in news.");
				} else {
					System.out.println("The search is successfull.");
					for (String st : s) {
						System.out.println("== " + st);
					}
				}
			} catch (DAOException e) {
				throw new ServiceException(e);
			}
		} else if (searchIn.equals(YEAR_PATTERN)) {
			searchFor = sc.nextLine();
			if (Validator.isYearValid(searchFor)) {
				try {
					ArrayList<String> s = DAOFactory.getInstance().getNewsDAO().findNews(searchIn, searchFor);
					if (s.isEmpty()) {
						System.out.println("There is no such element in news.");
					} else {
						System.out.println("The search is successfull.");
						for (String st : s) {
							System.out.println("== " + st);
						}
					}
				} catch (DAOException e) {
					throw new ServiceException(e);
				}
			}
		} else {
			System.out.println("There is no such type of search. Please check your parameters.");
		}
	}

	private static void initializeOneNews(String s, News neToInit) throws ServiceException {
		String category = s.split(" / ")[0];
		if (category.equals(BOOK_PATTERN)) {
			neToInit = new Book(s);
		} else if (category.equals(FILM_PATTERN)) {
			try {
				neToInit = new Film(s);
			} catch (NumberFormatException e) {
				throw new ServiceException(e);
			}
		} else if (category.equals(DISK_PATTERN)) {
			neToInit = new Disk(s);
		} else {
			System.out.println("No such category.");
		}
	}
}
