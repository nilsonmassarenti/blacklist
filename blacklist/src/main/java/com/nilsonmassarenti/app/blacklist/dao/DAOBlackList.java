package com.nilsonmassarenti.app.blacklist.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.nilsonmassarenti.app.blacklist.model.BlackList;

/**
 * Class to Access Data
 * 
 * @author nilsonmassarenti - nilsonmassarenti@gmail.com
 * @version 0.1 Last update: 16-Apr-2015
 */

public class DAOBlackList implements DAOInterface {
	
	DAOConnection daoConnection = new DAOConnection();
	
	/**
	 * This method create the blacklist
	 * @param Object
	 * @return Boolean 
	 */
	public Boolean create(Object o) {
		try {
			Boolean wasSave = false;
			BlackList blackList = (BlackList) o;
			Connection connection = daoConnection.dbConnection();
			if (connection != null) {
				String sql = " SELECT 	* " + " FROM TBL_BLACKLIST "
						   + " WHERE 	BLACKLIST_EMAIL = '" + blackList.getEmail()
						   + "' " + "   AND BLACKLIST_DEL_DATE IS NULL";

				Statement stm = (Statement) connection.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				if (!rs.next()) {
					
					String sqlId = "SELECT NEXT VALUE FOR id_seq_blacklist AS id FROM TBL_BLACKLIST";
					ResultSet rs2 = stm.executeQuery(sqlId);
					Integer id = 1;
					if(rs2.next()){
						id = rs2.getInt("id");
					}
					
					String sqlInsert = " INSERT INTO TBL_BLACKLIST "
									 + "	(BLACKLIST_ID,"
									 + "	 BLACKLIST_EMAIL, "
									 + "	 BLACKLIST_ADD_DATE) "
									 + " VALUES ("+id+", "
									 + "        '"+blackList.getEmail()+"', "
									 + "         NOW())";
					stm.executeUpdate(sqlInsert);
					wasSave = true;
					rs2.close();
				}
				rs.close();
				stm.close();
				connection.close();
				
			}
			return wasSave;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * This method read the blacklist
	 * @param Object
	 * @return Boolean 
	 */
	public ArrayList<Object> read(Object o) {
		ArrayList<Object> arrayBlackList = new ArrayList<Object>();
		try {
			Connection connection = daoConnection.dbConnection();
			if (connection != null) {
				String sql = " SELECT 	BLACKLIST_ID, " 
						+ " 			BLACKLIST_EMAIL, "
						+ " 			BLACKLIST_ADD_DATE, " 
						+ " 			BLACKLIST_DEL_DATE "
						+ " FROM		TBL_BLACKLIST "
						+ " WHERE		BLACKLIST_DEL_DATE IS NULL" 
						+ " ORDER BY 	BLACKLIST_EMAIL ";

				Statement stm = (Statement) connection.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while (rs.next()) {
					BlackList blackList = new BlackList();
					blackList.addBlackList(rs.getInt("BLACKLIST_ID"),
							rs.getString("BLACKLIST_EMAIL"),
							rs.getDate("BLACKLIST_ADD_DATE"),
							rs.getDate("BLACKLIST_DEL_DATE"));
					arrayBlackList.add(blackList);
				}
				rs.close();
				stm.close();
				connection.close();
			}
			return arrayBlackList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public Boolean update(Object o) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * This method delete the blacklist
	 * @param Object
	 * @return Boolean 
	 */
	public Boolean delete(Object o) {
		Connection connection = daoConnection.dbConnection();
		try {
			Statement stm = (Statement) connection.createStatement();
			String email = (String) o;
			String sqlDelete = " UPDATE  TBL_BLACKLIST "
							 + " SET 	 BLACKLIST_DEL_DATE = NOW() "
							 + " WHERE 	 BLACKLIST_EMAIL = '"+email+ "'"
							 + "		 AND BLACKLIST_DEL_DATE IS NULL";
			stm.executeUpdate(sqlDelete);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * This method set properties
	 * @param Properties
	 */
	public void setProperties(Properties props){
		daoConnection.setProps(props);
	}

}
