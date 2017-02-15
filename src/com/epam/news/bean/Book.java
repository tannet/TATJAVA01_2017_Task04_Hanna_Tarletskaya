package com.epam.news.bean;

public class Book extends News {
	private String genre;

	public Book(String s) {
		super(s);
		setGenre(s.split(" / ")[4]);
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "BOOK: " + super.toString() + ", genre: " + genre;
	}

}
