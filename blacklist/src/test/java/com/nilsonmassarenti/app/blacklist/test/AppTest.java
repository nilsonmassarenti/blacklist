package com.nilsonmassarenti.app.blacklist.test;

import java.sql.Connection;
import java.util.Properties;

import junit.framework.TestCase;

import com.nilsonmassarenti.app.blacklist.conf.Informations;
import com.nilsonmassarenti.app.blacklist.controller.ControllerBlackList;
import com.nilsonmassarenti.app.blacklist.dao.DAOBlackList;
import com.nilsonmassarenti.app.blacklist.dao.DAOConnection;

public class AppTest extends TestCase {
	private Properties props = Informations.getProperties("/Users/nilsonmassarenti/Development/tests/blacklist/conf/conf.properties");
	
	/**
	 * Tests of database
	 */
	public void testConnection(){
		DAOConnection daoConnection = new DAOConnection();
		daoConnection.setProps(this.props);
		Connection connection = daoConnection.dbConnection();
		assertNotNull(connection);
	}
	
	public void testReadDAOBlacklist(){
		DAOBlackList daoBlackList = new DAOBlackList();
		daoBlackList.setProperties(props);
		assertTrue(daoBlackList.read(null).size() > 0);
	}
	
	/**
	 * Tests of application
	 */
	
	public void testControllerBlacklist(){
		ControllerBlackList controllerBlackList = new ControllerBlackList();
		controllerBlackList.setProperties(props);
		assertTrue(controllerBlackList.listBlackList().size() > 0);
	}
	
	

}
