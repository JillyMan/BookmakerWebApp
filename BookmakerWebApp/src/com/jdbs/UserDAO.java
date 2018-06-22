package com.jdbs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.domain.*;
import com.jdbs.interfaces.GenericDao;
import com.jdbs.oracledb.OracleConnector;

public class UserDAO implements GenericDao<User, Integer>{

	public void insert(User name) {
						
		String sql = "INSERT INTO USERS(USERID, FIRSTNAME, LASTNAME, SCORE, LOGIN, PASSWORD, ROLE)"
				+ "VALUES(SQ_USERS.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		
		Connection connection = null;
		PreparedStatement statement = null;
		try{
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, name.getFirstName());
			statement.setString(2, name.getLastName());
			statement.setInt(3, 0);
			statement.setString(4, name.getLogin());
			statement.setString(5, name.getPassword());
			statement.setInt(6, 1);
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

	public User getByKey(Integer key) {
		String sql = "SELECT * FROM USERS WHERE USERID= ?";

		Connection connection  = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		User user = null;
		try {
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, key);
			result = statement.executeQuery();
			user = parseResultSet(result).get(0);
		}catch(Exception e) {
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
		
		return user;
	}
	
	//TODO: REFACTORING.....
	public boolean getByLogin(String login) {
		String sql = "SELECT * FROM USERS WHERE LOGIN=?";

		Connection connection  = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		User user = null;
		try {
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, login);
			result = statement.executeQuery();

			user = parseResultSet(result).get(0);
		}catch(Exception e) {
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
		boolean res = (user != null);	
		return res;
	}

	public User getByLoginAndPassword(String login, String password) {
		String sql = "SELECT * FROM USERS WHERE LOGIN=? AND PASSWORD=?";

		Connection connection  = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		User user = null;
		try {
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, login);
			statement.setString(2, password);
			result = statement.executeQuery();
			user = parseResultSet(result).iterator().next();
		}catch(Exception e) {
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
		
		return user;
	}
	
	@Override
	public List<User> getAll() {
		String sql = "SELECT * FROM USERS ORDER BY USERID";
		List<User> list = new ArrayList<User>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null; 
		
		try {
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			result.next();
			list = parseResultSet(result);			
		} catch(SQLException e) {
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
				
		return list;
	}
	
	private List<User> parseResultSet(ResultSet result){
		List<User> list = new ArrayList<User>();
		try {
			while(result.next()) {
				User user = new User(result.getString("FIRSTNAME"), result.getString("LASTNAME"), 
						result.getString("LOGIN"), result.getString("PASSWORD"));
				user.setId(result.getInt("USERID"));
				user.setScore(result.getInt("SCORE"));
				user.setRole(result.getInt("ROLE"));
				list.add(user);
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return list;
	}

	@Override
	public void update(User object) {
		String sql = "UPDATE USERS SET "
					+ "FIRSTNAME=?, "
					+ "LASTNAME=?, "
					+ "SCORE=?, "
					+ "LOGIN=?, "
					+ "PASSWORD=?, "
					+ "ROLE =? "
					+ "WHERE USERID=?";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, object.getFirstName());
			statement.setString(2, object.getLastName());
			statement.setInt(3, object.getScore());
			statement.setString(4, object.getLogin());
			statement.setString(5, object.getPassword());
			statement.setInt(6, object.getRole());
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

	
	//TODO: need back and change!!!
	@Override
	public void delete(User object) {
		String sql = "DELETE FROM USERS WHERE USERID=?";		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = OracleConnector.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, object.getId());
			statement.execute();			
		} catch(SQLException e) {
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
	
}
