package com.jdbs.oracledb;

import java.util.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class OracleConnector {
	private String user = "artyomRoot";
	private String password = "toor";
	private String url = "jdbc:oracle:thin:@localhost:1521:db";

	private static OracleConnector factory = null;
	
	private OracleConnector () {
		
	}
    
    public static OracleConnector getInstance() {
    	if(factory == null) {
    		factory = new OracleConnector ();
    		try {
	    		factory.loadProperties();
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	return factory;
    }
    
	public Connection getConnection() {
		Connection conn = null;
		try {			
			OracleDataSource ds = new OracleDataSource();
			ds.setURL(url);			
			conn = ds.getConnection(user, password);
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}	
	
    private void loadProperties() {
    	Properties properties = new Properties();
    	try {
    		properties.load(OracleConnector.class.getResourceAsStream("db.properties"));
    		user = properties.getProperty("user");
    		password = properties.getProperty("password");
    		url = properties.getProperty("url");
    	} catch(IOException e) {
    		e.printStackTrace();
    		System.out.println("canot read file!!" + "db.properties");
    	}    	
    }   
}
