package com.nilsonmassarenti.app.blacklist.conf;

import java.util.Properties;

import org.hsqldb.server.Server;

public class AdministrateServer {

	// start the DATABASE
	public void startDB(String path) {
		Properties props = Informations.getProperties(path);
		Server dbServer = new Server();
		dbServer.stop();
		dbServer.setDatabaseName(0, props.getProperty("prop.database.name"));
		dbServer.setDatabasePath(0,
				"jdbc:hsqldb:file:" + props.getProperty("prop.database.path"));
		dbServer.start();
	}

}
