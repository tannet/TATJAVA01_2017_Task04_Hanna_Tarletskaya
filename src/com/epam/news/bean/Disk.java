package com.epam.news.bean;

public class Disk extends News {
	private String duration;

	public Disk(String s) {
		super(s);
		setDuration(s.split(" / ")[4]);
	}

	public String getduration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "DISK: " + super.toString() + ", duration: " + duration;
	}
}
