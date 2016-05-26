package com.nilsonmassarenti.app.blacklist.dao;

import java.sql.Connection;
import java.util.Properties;

/**
 * Class to Create connection
 * 
 * @author nilsonmassarenti - nilsonmassarenti@gmail.com
 * @version 0.1 Last update: 16-Apr-2015
 */

public class DAOConnection {
	private Properties props;
	
	/**
	 * This method connection with database
	 * @return Connection 
	 */
	public Connection dbConnection() {
		String url = "jdbc:hsqldb:file:"+props.getProperty("prop.database.path");
		Connection dbConn = DAOFactory.connection(url, props.getProperty("prop.database.user"), props.getProperty("prop.database.pass"));
		return dbConn;
	}

	/**
	 * This method set properties
	 * @param Properties
	 */
	public void setProps(Properties props) {
		this.props = props;
	}
	
	
}
