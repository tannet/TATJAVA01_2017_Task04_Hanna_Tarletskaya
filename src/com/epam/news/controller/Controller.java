package com.epam.news.controller;

import java.util.Map;

import com.epam.news.controller.exception.ControllerException;
import com.epam.news.service.exception.ServiceException;
import com.epam.news.service.factory.ServiceFactory;

public class Controller {
	private static final String COMMAND = "command";
	private static final String TEXT = "text";
	private static final String ADD = "ADD";
	private static final String FIND = "FIND";
	private static final String EXIT = "EXIT";

	public static void request(Map<String, String> map) throws ControllerException{
		if (map.get(COMMAND).equals(ADD)) {
			try {
				ServiceFactory.getInstance().getPortalService().addNews(map.get(TEXT));
			} catch (ServiceException e) {
				throw new ControllerException(e);
			}
		} else if (map.get(COMMAND).equals(FIND)) {
			try {
				ServiceFactory.getInstance().getPortalService().findNews(map.get(TEXT));
			} catch (ServiceException e) {
				throw new ControllerException(e);
			}
		} else if (map.get(COMMAND).equals(EXIT)) {
			System.out.println("EXIT command was found."); //and??
		} else {
			System.out.println("There is no such type of command. Please check your parameters.");
		}
	}
	// IT SHOULD RETURN RESPONSE TO THE VIEW?
}
