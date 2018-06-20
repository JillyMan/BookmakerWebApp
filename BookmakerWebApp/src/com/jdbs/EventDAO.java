package com.jdbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.Event;
import com.jdbs.interfaces.GenericDao;
import com.jdbs.oracledb.OracleConnector;

public class EventDAO implements GenericDao<Event, Integer>{
	@Override
	public boolean insert(Event object) {

		String sql = "INSERT INTO EVENT(EVENTID, NAME_EVENT, DATETIME_EVENT, TPYE_SPORTID)"
				+ "VALUES(SQ_EVENT.NEXTVAL, ?, ?, ?)";
		
		Connection connection = null;
		PreparedStatement statement = null;
		boolean result = false;
		try{
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, object.getNameEvent());
			statement.setTimestamp(2, object.getTimestamp());
			statement.setInt(3, object.getTypeSportId());			
			result = statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) connection.close();
				if(statement != null) statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public void update(Event object) {
		String sql = "UPDATE EVENT SET "
					+ "NAME_EVENT=? "
					+ "TYPE_SPORTID=?"
					+ "DATETIME_EVENT=?"
					+ "WHERE EVENTID=?";
		
		Connection connection = null;
		PreparedStatement statement = null;
	
		try {
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, object.getNameEvent());
			statement.setInt(2, object.getTypeSportId());
			statement.setTimestamp(3, object.getTimestamp());
			statement.setInt(4, object.getId());			
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
	public void delete(Event object) {
		String sql = "DELETE FROM EVENT WHERE EVENTID=?";		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, object.getId());
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
	public List<Event> getAll() {		
		String sql = "SELECT * FROM EVENT";

		List<Event> list = null;
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

	private List<Event> parseResultSet(ResultSet result){
		List<Event> list = new ArrayList<Event>();
		try {
			while(result.next()) {
				Event type = new Event(
						result.getString("NAME_EVENT"), 
						result.getTimestamp("DATETIME_EVENT"), 
						result.getInt("TYPE_SPORTID"));
				type.setId(result.getInt("EVENTID"));
				list.add(type);				
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Event getByKey(Integer object) {
		String sql = "SELECT * FROM EVENT";

		Event type = null;
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
