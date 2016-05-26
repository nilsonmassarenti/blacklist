package com.nilsonmassarenti.app.blacklist.view;

/**
 * This class is responsable to Rest of application
 * @author nilsonmassarenti - nilsonmassarenti@gmail.com
 * @version 0.1
 * Last update: 16-Apr-2015
 */

import java.util.ArrayList;
import java.util.Properties;

import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nilsonmassarenti.app.blacklist.conf.Informations;
import com.nilsonmassarenti.app.blacklist.controller.ControllerBlackList;
import com.nilsonmassarenti.app.blacklist.model.BlackList;
import com.nilsonmassarenti.app.blacklist.model.BlackListURI;

@RestController
public class ViewRestBlackList implements CommandLineRunner {
	
	//This object is unique to the system, 
	//when request has not necessary to updated
	//except if the operations like update, delete or create.
	private ArrayList<Object> arrayBlackList = new ArrayList<Object>();
	
	private ControllerBlackList controllerBlackList = new ControllerBlackList();
	
	/**
	 * This Method is responsible to save the blacklist
	 * */
	@RequestMapping(value = BlackListURI.CREATE_BLACKLIST)
	public @ResponseBody Object saveBlackList(@RequestBody BlackList blackList){
		if (controllerBlackList.addBlackList(blackList)	) {
			updateBlackList();
		}
		return arrayBlackList;
	}
	
	/**
	 * This Method is responsible to return a list of blacklist
	 * */
	@RequestMapping(value = BlackListURI.GET_ALL_BLACKLIST)
	public @ResponseBody Object readBlackList(){
		if (this.arrayBlackList.size() == 0) {
			updateBlackList();
		}
		return arrayBlackList;
	}
	
	/**
	 * This Method is responsible to save the blacklist
	 * */
	@RequestMapping(value = BlackListURI.DELETE_BLACKLIST)
	public @ResponseBody Object deleteBlackList(@RequestParam(value = "email", required = false) String email){
		if (controllerBlackList.delBlackList(email)) {
			updateBlackList();
			return arrayBlackList;
		} else {
			return null;
		}
	}
	
	/**
	 * This Method is responsible to update the blacklist
	 * */
	private void updateBlackList(){
		this.arrayBlackList = controllerBlackList.listBlackList();
	}
	
	/**
	 * This Method is override the run to get the arguments
	 * */
	public void run(String... args) throws Exception {
		Properties props = Informations.getProperties(args[0]);
		controllerBlackList.setProperties(props);
	}
}
