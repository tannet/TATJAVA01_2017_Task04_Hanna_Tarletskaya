//package com.epam.news.dao.impl;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//
//import com.epam.news.bean.News;
//import com.epam.news.dao.exception.DAOException;
//import com.epam.news.dao.interfaces.NewsDAO;
//
//public class FileNewsDAO implements NewsDAO {
//
//	private static String FILENAME = "news.txt";
//	private static FileWriter writer;
//	private static BufferedReader reader;
//
//	@Override
//	public void addNews(String newsToAdd) throws DAOException {
//		writeFile(newsToAdd);
//	}
//
//	@Override
//	public ArrayList<String> findNews() {
//		return readFile();
//	}
//
//	/// File actions: ///
//	// in other class?
//	private static ArrayList<String> readFile() {
//		File fileIn = new File(FILENAME);
//		ArrayList<String> allNews = new ArrayList<>();
//		try {
//			reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileIn)));
//			String line;
//			while ((line = reader.readLine()) != null) {
//				allNews.add(line);
//			}
//		} catch (IOException e) {
//			System.out.println("File reading error");
//		} finally {
//			try {
//				writer.close();
//			} catch (IOException e) {
//				System.out.println("File closing after reading error");
//			}
//		}
//		return allNews;
//	}
//
//	private static void writeFile(String result) throws DAOException {
//		File fileOut = new File(FILENAME);
//		try {
//			writer = new FileWriter(fileOut, true);
//			writer.write("\n");
//			writer.write(result);
//			writer.flush();
//		} catch (FileNotFoundException e) {
//			throw new DAOException(e);
//		} catch (IOException e) {
//			System.out.println("File writing error");
//		} finally {
//			try {
//				writer.close();
//			} catch (IOException e) {
//				System.out.println("File closing after writing error");
//			}
//		}
//	}
//
//	@Override
//	public void addNews(News news) throws DAOException {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	public ArrayList<String> findNews(News news) throws DAOException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
