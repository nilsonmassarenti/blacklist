package com.nilsonmassarenti.app.blacklist;

/**
 * Class to start the application
 * @author nilsonmassarenti - nilsonmassarenti@gmail.com
 * @version 0.1
 * Last update: 16-Apr-2015
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nilsonmassarenti.app.blacklist.conf.AdministrateServer;

@SpringBootApplication

public class App 
{
    public static void main( String[] args )
    {	
    	if (args.length > 0) {
	    	AdministrateServer administrateServer = new AdministrateServer();
	    	administrateServer.startDB(args[0]);
	    	SpringApplication.run(App.class, args); 
		} else {
			System.err.println("Application not open, because configuration path is null");
		}

    	
    }
}
