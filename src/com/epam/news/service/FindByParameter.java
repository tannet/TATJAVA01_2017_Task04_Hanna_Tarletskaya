package com.epam.news.service;

import java.util.ArrayList;

import com.epam.news.bean.News;

public class FindByParameter {
	public static ArrayList<News> find(String searchIn, String searchFor, ArrayList<News> allNews) {
		ArrayList<News> resultSet = new ArrayList<>();
		switch (searchIn) {
		case "Category":
			findByCategory(searchFor, allNews, resultSet);
			break;
		case "Title":
			findByTitle(searchFor, allNews, resultSet);
			break;
		case "Author":
			findByAuthor(searchFor, allNews, resultSet);
			break;
		case "Year":
			findByYear(searchFor, allNews, resultSet);
			break;
		default:
			System.out.println("Your request can not be found.");
		}
		return resultSet;
	}

	private static void findByCategory(String searchFor, ArrayList<News> allNews, ArrayList<News> resultSet) {
		for (News n : allNews) {
			if (n.getCategory().equals(searchFor)) {
				resultSet.add(n);
				//System.out.println(n.toString());
			}
		}
	}

	private static void findByTitle(String searchFor, ArrayList<News> allNews, ArrayList<News> resultSet) {
		for (News n : allNews) {
			if (n.getTitle().equals(searchFor)) {
				resultSet.add(n);
				//System.out.println(n.toString());
			}
		}
	}

	private static void findByAuthor(String searchFor, ArrayList<News> allNews, ArrayList<News> resultSet) {
		for (News n : allNews) {
			if (n.getAuthor().equals(searchFor)) {
				resultSet.add(n);
				//System.out.println(n.toString());
			}
		}
	}

	private static void findByYear(String searchFor, ArrayList<News> allNews, ArrayList<News> resultSet) {
		for (News n : allNews) {
			if (n.getYear() == Integer.parseInt(searchFor)) {
				resultSet.add(n);
				//System.out.println(n.toString());
			}
		}
	}
}
