package com.nilsonmassarenti.app.blacklist.model;

import java.util.Date;

/**
 * This class is model to information of system.
 * @author nilsonmassarenti - nilsonmassarenti@gmail.com
 * @version 0.1
 * Last update: 16-Apr-2015
 */

public class BlackList {

	private Integer id;
	private String email;
	private Date addDate;
	private Date delDate;

	public void addBlackList(Integer id, String email, Date addDate, Date delDate){
		this.id = id;
		this.email = email;
		this.addDate = addDate;
		this.delDate = delDate;
	}

	public Integer getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}

	public Date getAddDate() {
		return addDate;
	}

	public Date getDelDate() {
		return delDate;
	}

}
