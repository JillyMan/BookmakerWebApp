package com.jdbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.Contest;
import com.jdbs.interfaces.GenericDao;
import com.jdbs.oracledb.OracleConnector;

public class ContestDAO implements GenericDao<Contest, Integer>{
	
	@Override
	public void insert(Contest object) {

		String sql = "INSERT INTO CONTEST(EVENTID, TEAMID)"
				+ "VALUES(?, ?)";
		
		Connection connection = null;
		PreparedStatement statement = null;
		try{
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, object.getEventId());
			statement.setInt(2, object.getTeamId());
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(connection != null)
				try {
					if(connection != null) connection.close();
					if(statement != null) statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	@Override
	public void update(Contest object) {
		String sql = "UPDATE CONTEST SET "
					+ "TEAMID=? "
					+ "WHERE EVENTID=?";
		
		Connection connection = null;
		PreparedStatement statement = null;
	
		try {
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, object.getEventId());
			statement.setInt(2, object.getTeamId());
			statement.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(connection != null) connection.close();
				if(statement != null) statement.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}	
	}

	@Override
	public void delete(Contest object) {
		String sql = "DELETE FROM CONTEST WHERE EVENTID=? ";		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, object.getEventId());
			statement.execute();			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {			
			try {
				if(connection != null) connection.close();
				if(statement != null) statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	} 	

	@Override
	public List<Contest> getAll() {		
		String sql = "SELECT * FROM CONTEST";

		List<Contest> list = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result  = null;
		try {
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();		
			list = parseResultSet(result);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {				
				if(connection != null) connection.close();
				if(statement != null) statement.close();
				if(result != null) result.close();			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}	
		
		return list;
	}

	private List<Contest> parseResultSet(ResultSet result){
		List<Contest> list = new ArrayList<Contest>();
		try {
			while(result.next()) {
				Contest type = new Contest(
						result.getInt("EVENTID"), 
						result.getInt("TEAMID"));
				list.add(type);				
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Contest getByKey(Integer object) {
		String sql = "SELECT * FROM CONTEST";

		Contest type = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result  = null;
		try {
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();		
			type = parseResultSet(result).get(0);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {				
				if(connection != null) connection.close();
				if(statement != null) statement.close();
				if(result != null) result.close();			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return type;
	}
}
