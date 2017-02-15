package com.epam.news.dao.connectionpool;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.epam.news.dao.exception.DAOException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public final class ConnectionPool {
	private BlockingQueue<Connection> connectionQueue;
	private BlockingQueue<Connection> givenAwayConQueue;
	
	private String driverName;
	private String url;
	private String user;
	private String password;
	private int poolSize;
	private int count;


	private static ConnectionPool instace = null;

	public static ConnectionPool getInstace() throws DAOException {
		if (instace == null) {
			try {
				instace = new ConnectionPool();
			} catch (DAOException e) {
				throw e;
			}
		}
		return instace;
	}

	private ConnectionPool() throws DAOException {

		this.driverName = DBInitializ.dbDriver;
		this.url = DBInitializ.dbUrl;
		this.user = DBInitializ.dbUser;
		this.password = DBInitializ.dbPassword;
		try {
			this.poolSize = Integer.parseInt(DBInitializ.dbPoolSize);
		} catch (NumberFormatException e) {
			poolSize = 5;
		}
		// ???
		try {
			initPoolData();
		} catch (DAOException e) {
			throw e;
		}
	}
	
	public void initPoolData() throws DAOException {

		try {
			Class.forName(driverName);
			givenAwayConQueue = new ArrayBlockingQueue<Connection>(poolSize);
			connectionQueue = new ArrayBlockingQueue<Connection>(poolSize);
			for (int i = 0; i < poolSize; i++) {
				Connection connection = (Connection) DriverManager.getConnection(url, user,password);
				connectionQueue.add(connection);
			}
		} catch (SQLException e) {
			throw new DAOException("SQLException in ConnetionPool.", e);
		} catch (ClassNotFoundException e) {
			throw new DAOException("Can't find database driver class.", e);
		}
	}

	public void dispose() {
		clearConnectionQueue();
	}

	private void clearConnectionQueue() {

		try {
			closeConnectionQueue(givenAwayConQueue);
			closeConnectionQueue(connectionQueue);
		} catch (SQLException e) {
		}
	}

	public Connection takeConnection() throws DAOException {
		
		Connection connection = null;
		try {
			connection = connectionQueue.take();
			givenAwayConQueue.add(connection);
		} catch (InterruptedException e) {
			throw new DAOException("Error connection to the data source.", e);
		}
		return connection;

	}

	private void closeConnection(Connection connection, Statement st,ResultSet rs) {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Connection isn't return to the pool.");
		}
		try {
			st.close();
		} catch (SQLException e) {
			System.out.println("Connection isn't closed.");
		}
		try {
			rs.close();
		} catch (SQLException e) {
			System.out.println("Connection isn't closed.");
		}

	}

	private void closeConnection(Connection connection, Statement st) {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Connection isn't return to the pool.");
		}
		try {
			st.close();
		} catch (SQLException e) {
			System.out.println("Connection isn't closed.");
		}
	}
	
	private void closeConnectionQueue(BlockingQueue<Connection> queue)
			throws SQLException {
		Connection connection = null;
		while ((connection = queue.poll()) != null) {
			if (!connection.getAutoCommit()) {
				connection.commit();
			}
			connection.close();
		}
	}
}
