package com.nilsonmassarenti.app.blacklist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {
	public static Connection connection(String url, String user, String pass) {
		Connection connection;
		try {
			connection = DriverManager.getConnection(url, user, pass);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
}
