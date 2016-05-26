package com.nilsonmassarenti.app.blacklist.conf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Informations {
	public static Properties getProperties(String path){
		Properties props = new Properties();
		try {
			FileInputStream file = new FileInputStream(path);
			props.load(file);
			return props;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
