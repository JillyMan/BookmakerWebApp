package com.jdbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.Team;
import com.jdbs.interfaces.GenericDao;
import com.jdbs.oracledb.OracleConnector;

public class TeamDAO implements GenericDao<Team, Integer>{

	@Override
	public boolean insert(Team object) {

		String sql = "INSERT INTO TEAMS(TYPEID, TEAMNAME)"
				+ "VALUES(SQ_TEAMS.NEXTVAL, ?)";
		
		Connection connection = null;
		PreparedStatement statement = null;
		boolean result = false;
		try{
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, object.getNameTeam());
			result = statement.execute();
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
		return result;
	}

	@Override
	public void update(Team object) {
		String sql = "UPDATE TEAMS SET "
					+ "TEAMNAME=? "
					+ "WHERE TYPEID=?";
		
		Connection connection = null;
		PreparedStatement statement = null;
	
		try {
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, object.getNameTeam());
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
	public void delete(Team object) {
		String sql = "DELETE FROM TEAMS WHERE TYPEID=?";
		
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
	public List<Team> getAll() {		
		String sql = "SELECT * FROM TEAMS";

		List<Team> list = null;
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

	private List<Team> parseResultSet(ResultSet result){
		List<Team> list = new ArrayList<Team>();
		try {
			while(result.next()) {
				Team type = new Team(result.getString("TEAMNAME"));
				type.setId(result.getInt("TEAMID"));
				list.add(type);				
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Team getByKey(Integer object) {
		String sql = "SELECT * FROM TEAMS";

		Team type = null;
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
