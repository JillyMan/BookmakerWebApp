package com.jdbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.AllPlacedBets;
import com.jdbs.interfaces.GenericDao;
import com.jdbs.oracledb.OracleConnector;

public class AllPlacedBetsDAO implements GenericDao<AllPlacedBets, Integer>{
	@Override
	public void insert(AllPlacedBets object) {
		String sql = "INSERT INTO ALL_BETS_PLACED_USERS("
				+ "USERID, BETSID, SUMMA)"
				+ "VALUES(?, ?, ?)";
		
		Connection connection = null;
		PreparedStatement statement = null;
		try{
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, object.getUserId());
			statement.setInt(2, object.getBetsId());
			statement.setInt(3, object.getSumma());			
			statement.execute();
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
	}

	@Override
	public void update(AllPlacedBets object) {
		String sql = "UPDATE ALL_BETS_PLACED_USERS SET "
					+ "SUMMA=?"
					+ "WHERE USERID=? AND BETSID=?";
		
		Connection connection = null;
		PreparedStatement statement = null;
	
		try {
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, object.getSumma());
			statement.setInt(2, object.getUserId());
			statement.setInt(3, object.getBetsId());
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
	
	//TODO: ?
	@Override
	public void delete(AllPlacedBets object) {
//		String sql = "DELETE FROM ALL_BETS_PLACED_USERS WHERE EVENTID=?";		
//		Connection connection = null;
//		PreparedStatement statement = null;
//		
//		try {
//			connection = OracleConnector.getInstance().getConnection();
//			statement = connection.prepareStatement(sql);
//			statement.setInt(1, object.getId());
//			statement.execute();			
//		} catch(SQLException e) {
//			e.printStackTrace();
//		} finally {			
//			try {
//				if(connection != null) connection.close();
//				if(statement != null) statement.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}		
	} 	

	public List<AllPlacedBets> getAllByKeyUserId(Integer userId) {
		String sql = "SELECT * FROM ALL_BETS_PLACED_USERS WHERE USERID=?";

		List<AllPlacedBets> list = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result  = null;

		try {
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, userId);
			result = statement.executeQuery();	
			list = parseResultSet(result);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {				
				if(connection != null) connection.close();
				if(statement != null) statement.close();
				if(result != null) result.close();			
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}		
		return list;
	}
	
	@Override
	public List<AllPlacedBets> getAll() {		
		String sql = "SELECT * FROM ALL_BETS_PLACED_USERS";

		List<AllPlacedBets> list = null;
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

	private List<AllPlacedBets> parseResultSet(ResultSet result){
		List<AllPlacedBets> list = new ArrayList<AllPlacedBets>();
		try {
			while(result.next()) {
				AllPlacedBets type = new AllPlacedBets(
						result.getInt("USERID"), 
						result.getInt("BETSID"), 
						result.getInt("SUMMA"));
				list.add(type);				
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public AllPlacedBets getByKey(Integer Id) {
		//TODO: JUST WRITE COMMENT :)
		return null;
	}
}
