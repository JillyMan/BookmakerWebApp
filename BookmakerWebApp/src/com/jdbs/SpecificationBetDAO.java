package com.jdbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.Event;
import com.domain.SpecificationBet;
import com.domain.enums.StatusBets;
import com.jdbs.interfaces.GenericDao;
import com.jdbs.oracledb.OracleConnector;

public class SpecificationBetDAO implements GenericDao<SpecificationBet, Integer>{

	@Override
	public void insert(SpecificationBet object) {
		
		String sql = "INSERT INTO SPEC_BETS(SPEC_BETSID, TYPE_BETSID, COEFFICIENT, RESULT, EVENTID)"
				+ "VALUES(SQ_ORDIN_TYPE.NEXTVAL, ?, ?, ?, ?)";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {			
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, object.getTypeBetsId());
			statement.setDouble(2, object.getCoefficient());
			statement.setInt(3, object.getResult().getInt());			
			statement.setInt(4, object.getEventId());
			statement.execute();			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) connection.close();
				if(statement != null) statement.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(SpecificationBet object) {
		String sql = "UPDATE SPEC_BETS SET "
				+ "TYPE_BETS=? "
				+ "COEFFICIENT=?"
				+ "RESULT=?"
				+ "EVENTID=?"
				+ "WHERE SPEC_BETSID=?";

		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, object.getTypeBetsId());
			statement.setDouble(2, object.getCoefficient());
			statement.setInt(3, object.getResult().getInt());
			statement.setInt(4, object.getEventId());
			statement.setInt(5, object.getId());			
			statement.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(connection != null) connection.close();
				if(statement != null) statement.close();				
			} catch(SQLException e) {
				e.printStackTrace();
			}		
		}
	}

	@Override
	public void delete(SpecificationBet object) {
		String sql = "DELETE FROM SPEC_BETS WHERE SPEC_BETSID=?";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, object.getId());
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) connection.close();
				if(statement != null) statement.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}			
		}			
	}

	@Override
	public List<SpecificationBet> getAll() {
		String sql = "SELECT * FROM SPEC_BETS";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		List<SpecificationBet> list = null;
		
		try {
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			list = parseResultSet(result);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
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
	public SpecificationBet getByKey(Integer key) {
		
		String sql = "SELECT * FROM SPEC_BETS WHERE SPEC_BETSID=?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		SpecificationBet bet = null;		
		try {
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, key);
			result = statement.executeQuery();
			bet = parseResultSet(result).get(0);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) connection.close();
				if(statement != null) statement.close();
				if(result != null) result.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}		
		}				
		
		return bet;	
	}
	
	public List<SpecificationBet> getByEventId(Event event){

		String sql = "SELECT * FROM SPEC_BETS WHERE EVENTID=?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		List<SpecificationBet> bet = null;		
		
		try {
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, event.getId());				
			result = statement.executeQuery();
			bet = (parseResultSet(result));				
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) connection.close();
				if(statement != null) statement.close();
				if(result != null) result.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}		
		}				
		
		return bet;	
		
	}

	public SpecificationBet getByEventIdAndTypeBet(int eventid, int typeBetId){

		String sql = "SELECT * FROM SPEC_BETS WHERE EVENTID=? AND TYPE_BETSID=?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		SpecificationBet bet = null;		
		
		try {
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, eventid);
			statement.setInt(2, typeBetId);
			result = statement.executeQuery();
			bet = parseResultSet(result).iterator().next();				
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) connection.close();
				if(statement != null) statement.close();
				if(result != null) result.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}		
		}				
		
		return bet;	
		
	}
	
	private List<SpecificationBet> parseResultSet(ResultSet result) {
		List<SpecificationBet> list = new ArrayList<SpecificationBet>();		
		try {
			while(result.next()) {
				SpecificationBet bets = new SpecificationBet(
						result.getInt("TYPE_BETSID"), 
						result.getDouble("COEFFICIENT"), 
						StatusBets.getStatus(result.getInt("RESULT")),
						result.getInt("EVENTID"));
				bets.setId(result.getInt("SPEC_BETSID"));
				list.add(bets);
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}				
		return list;		
	}
}