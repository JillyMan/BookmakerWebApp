package com.jdbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.TypeBets;
import com.jdbs.interfaces.GenericDao;
import com.jdbs.oracledb.OracleConnector;

public class TypeBetsDAO implements GenericDao<TypeBets, Integer>{

	@Override
	public boolean insert(TypeBets object) {

		String sql = "INSERT INTO TYPE_SPORT(TYPEID, NAME_BETS)"
				+ "VALUES(SQ_ORDIN_TYPE.NEXTVAL, ?)";
		
		Connection connection = null;
		PreparedStatement statement = null;
		boolean result = false;
		try{
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, object.getTypeName());
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
	public void update(TypeBets object) {
		String sql = "UPDATE TYPE_BETS SET "
					+ "NAME_BETS =? "
					+ "WHERE TYPEID=?";
		
		Connection connection = null;
		PreparedStatement statement = null;
	
		try {
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, object.getTypeName());
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
	public void delete(TypeBets object) {
		String sql = "DELETE FROM TYPE_BETS WHERE TYPEID=?";
		
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
	public List<TypeBets> getAll() {		
		String sql = "SELECT * FROM TYPE_BETS";

		List<TypeBets> list = null;
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

	private List<TypeBets> parseResultSet(ResultSet result){
		List<TypeBets> list = new ArrayList<TypeBets>();
		try {
			while(result.next()) {
				TypeBets type = new TypeBets(result.getString("NAME_BETS"));
				type.setId(result.getInt("TYPEID"));
				list.add(type);				
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public TypeBets getByKey(Integer object) {
		String sql = "SELECT * FROM TYPE_BETS";

		TypeBets type = null;
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
