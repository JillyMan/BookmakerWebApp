package com.connector;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class ConnectorToDB {
	
	private static ConnectorToDB connector = null;
	private ConnectorToDB() {}

	public static ConnectorToDB getInstatnce() {
		if(connector == null) {
			connector = new ConnectorToDB();
		}
		return connector;
	}
	
	public Connection getConnection(String user, String password) throws SQLException {
		Connection conn = null;
		OracleDataSource ds = new OracleDataSource();
		String url = "jdbc:oracle:thin:@localhost:1521:db";
		ds.setURL(url);			
		conn = ds.getConnection(user, password);	
		return conn;
	}
}
