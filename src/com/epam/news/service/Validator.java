package com.epam.news.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	private final static String VALIDATION_PATTERN =  "^([^/]+(\\s/\\s))([^/]+(\\s/\\s))([^/]+(\\s/\\s))((189[6-9]|19[0-9][0-9]|20[0|1][0-7])(\\s/\\s))(((10(\\.0)?)|([0-9]\\.[0-9]))|((\\d){0,3}:(([0-5][0-9])|(60)))|(\\w)+)$";
	
	private final static String BOOK_PATTERN = "Book";
	private final static String FILM_PATTERN = "Film";
	private final static String DISK_PATTERN = "Disk";
	
	public static boolean isNewsToAddValid(String newsToAdd) {
		Pattern p = Pattern.compile(VALIDATION_PATTERN);
		Matcher m = p.matcher(newsToAdd);
		return m.matches();
	}

	public static boolean isCategoryValid(String category) {
		if (category.equals(BOOK_PATTERN) || category.equals(FILM_PATTERN) || category.equals(DISK_PATTERN)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isYearValid(String search) {
		try {
			int year = Integer.parseInt(search);
			if (year <= 2017 && year >= 1896) {
				return true;
			} else {
				System.out.println("Year must be integer number between 1896 and 2017.");
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
