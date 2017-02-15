package com.epam.news.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Actions {

	public static Map<String, String> readRequest(Scanner sc) {
		Map<String, String> requestMap = new HashMap<>();
	    System.out.println("Enter the command and the string below.");
		System.out.println("String format: [Category / Title / Author / Year / Additional info]");
		String command = sc.nextLine();
		requestMap.put("command", command.split(" ")[0]);
		String newsToAdd = sc.nextLine();
		requestMap.put("text", newsToAdd);
		return requestMap;
	}

	public static void printRequest(Map<String, String> m) {
		// smth for testing
		System.out.println(m.get("command"));
		System.out.println(m.get("text"));
	}
}