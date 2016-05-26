package com.nilsonmassarenti.app.blacklist.dao;

import java.util.ArrayList;

public interface DAOInterface {
	public Boolean create(Object o);
	public ArrayList<Object> read(Object o);
	public Boolean update(Object o);
	public Boolean delete(Object o);
}
