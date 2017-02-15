package com.epam.news.view;

import java.util.Map;
import java.util.Scanner;

import com.epam.news.controller.Controller;
import com.epam.news.controller.exception.ControllerException;

public class ViewClass {
	private final static String EXIT_PATTERN = "EXIT";

	public static void main(String[] args) {
		StartHelper.printHelper();
		Scanner sc = new Scanner(System.in);

		Map<String, String> request; // = Actions.readRequest(sc);
		while (true) {

			if (sc.nextLine().equals(EXIT_PATTERN)) {
				System.out.println("Programm exit.");
				break;
			} else {
				request = Actions.readRequest(sc);
				try {
					Controller.request(request);
				} catch (ControllerException e) {
					System.out.println("ERROR: " + e);
				}
			}
		}
	}
}
