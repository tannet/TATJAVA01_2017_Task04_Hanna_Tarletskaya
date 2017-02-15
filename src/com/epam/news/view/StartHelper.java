package com.epam.news.view;

public class StartHelper {
	public static void printHelper() {
		System.out.println("To run the program press ENTER.");
		System.out.println("To end the program enter the command EXIT and press ENTER.");
		System.out.println("2 types of command are available: ADD_NEWS, FIND_NEWS");
		System.out.println(
				"In the 1st line enter the COMMAND. In the 2d - string in valid format (below there are examples of valid string, between [] symbols). ");
		System.out.println("");
		System.out.println("        Valid formats for different commands:");
		System.out.println(
				"ADD_NEWS: [Category / Title / Author / Year / Additional info]   (*Field \"Year\" must be integer number between 1896 and 2017).");
		System.out.println("");
		System.out.println("        Categories: Film, Book , Disk.");
		System.out.println("");
		System.out.println("        Types of additional info in different categories:");
		System.out.println("Film: IMDb rating (valid format: double number between 0 and 10)");
		System.out.println("Book: Genre (valid format: one-word string)");
		System.out.println("Disk: Duration (valid format: [MM:SS] , SS between 00 and 59)");
		System.out.println("");
		System.out.println("        =======================================");
		System.out.println("");
	}
}
