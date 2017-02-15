package com.epam.news.service.interfaces;

import com.epam.news.service.exception.ServiceException;

public interface PortalService {
	public void addNews(String s) throws ServiceException;

	public void findNews(String s) throws ServiceException;

}
