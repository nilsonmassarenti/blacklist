package com.nilsonmassarenti.app.blacklist.controller;

import java.util.ArrayList;
import java.util.Properties;

import com.nilsonmassarenti.app.blacklist.dao.DAOBlackList;
import com.nilsonmassarenti.app.blacklist.model.BlackList;

/**
 * Class to control Trades
 * 
 * @author nilsonmassarenti - nilsonmassarenti@gmail.com
 * @version 0.1 Last update: 03-Mar-2015 12:10 am
 */

public class ControllerBlackList {
	private DAOBlackList daoBlackList = new DAOBlackList();
	
	public ArrayList<Object> listBlackList() {
		
		ArrayList<Object> arrayBlackList = daoBlackList.read(null);
		return arrayBlackList;
	}
	
	public Boolean addBlackList(BlackList blackList){
		if (daoBlackList.create(blackList)) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean delBlackList(String email){
		if (daoBlackList.delete(email)) {
			return true;
		} else {
			return false;
		}
	}

	public void setProperties(Properties props){
		daoBlackList.setProperties(props);;
	}
	
}
