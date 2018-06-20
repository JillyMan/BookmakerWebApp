package com.jdbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.TypeSport;
import com.jdbs.interfaces.GenericDao;
import com.jdbs.oracledb.OracleConnector;

public class TypeSportDAO implements GenericDao<TypeSport, Integer>{

	@Override
	public void insert(TypeSport object) {

		String sql = "INSERT INTO TYPE_SPORT(TYPEID, TYPE_NAME)"
				+ "VALUES(SQ_TYPE_SPORT.NEXTVAL, ?)";
		
		Connection connection = null;
		PreparedStatement statement = null;
		try{
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, object.getTypeName());
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
	public void update(TypeSport object) {
		String sql = "UPDATE TYPE_SPORT SET "
					+ "TYPE_NAME =? "
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
	public void delete(TypeSport object) {
		String sql = "DELETE FROM TYPE_SPORT WHERE TPYEID=?";		
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
	public List<TypeSport> getAll() {		
		String sql = "SELECT * FROM TYPE_SPORT";

		List<TypeSport> list = null;
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

	private List<TypeSport> parseResultSet(ResultSet result){
		List<TypeSport> list = new ArrayList<TypeSport>();
		try {
			while(result.next()) {
				TypeSport type = new TypeSport(result.getString("TYPE_NAME"));
				type.setId(result.getInt("TYPEID"));
				list.add(type);				
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public TypeSport getByKey(Integer object) {
		String sql = "SELECT * FROM TYPE_SPORT WHERE TYPEID=?";

		TypeSport type = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result  = null;
		try {
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, object);
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
