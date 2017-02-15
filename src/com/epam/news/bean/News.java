package com.epam.news.bean;

public class News {

	private String category;
	private String title;
	private String author;
	private int year;

	public News(String s) {
		String[] initValues = s.split(" / ");
		setCategory(initValues[0]);
		setTitle(initValues[1]);
		setAuthor(initValues[2]);
		setYear(Integer.parseInt(initValues[3]));
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "category: " + category + ", title: " + title + ", author: " + author + ", year: " + year;
	}
}
