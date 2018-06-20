package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.base_type.*;

public class UserDAO implements IDao<User>{

	@Override
	public void insert(User name, Connection conn) throws Exception {
		String sql = "INSERT INTO USERS(USERID, FIRSTNAME, LASTNAME, SCORE, LOGIN, PASSWORD, ROLE)"
				+ "VALUES(SQ_USERS.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pStm = conn.prepareStatement(sql);
		pStm.setString(1, name.getFirstName());
		pStm.setString(2, name.getLastName());
		pStm.setInt(3, 0);
		pStm.setString(4, name.getLogin());
		pStm.setString(5, name.getPassword());
		pStm.setInt(6, 1);
		pStm.execute();
		pStm.close();
	}

	@Override
	public User find(int id, Connection conn) throws Exception {
		String sql = "SELECT * FROM USERS WHERE USERID = ? ORDER BY USERID";
		PreparedStatement pStm = conn.prepareStatement(sql);
		pStm.setInt(1, id);
		ResultSet result = pStm.executeQuery();
		result.next();
			
		Role role = Role.toRole(result.getInt("ROLE"));
		User user = new User(result.getString("FIRSTNAME"), result.getString("LASTNAME"), 
				result.getInt("SCORE"), result.getString("LOGIN"), result.getString("PASSWORD"), role);
		user.setId(result.getInt("USERID"));
				
		return user;
	}
	
	public User getUserByLoginPassword(String login, String password, Connection conn) throws SQLException {
		String sql = "SELECT * FROM USERS WHERE LOGIN = ? AND PASSWORD = ?";
		PreparedStatement pStm = conn.prepareStatement(sql);
		pStm.setString(1, login);
		pStm.setString(2, password);
		
		ResultSet result = pStm.executeQuery();
		
		User user = null;
		if(result.next() == true) {
			user = new User();
			user.setId(result.getInt("USERID"));
			user.setFirstName(result.getString("FIRSTNAME"));
			user.setLastName(result.getString("LASTNAME"));
			user.setScore(result.getInt("SCORE"));
			user.setLogin(login);
			user.setPassword(password);
			user.setRole(Role.toRole(result.getInt("ROLE")));			
		}
		result.close();
		pStm.close();				
		return user;
	}
	
	@Override
	public List<User> select(Connection conn) throws Exception {
		String sql = "SELECT * FROM USERS ORDER BY USERID";
		List<User> list = new ArrayList<User>();
		PreparedStatement pStm = conn.prepareStatement(sql);
		ResultSet result = pStm.executeQuery();
			
		while(result.next()) {
			Role role = Role.toRole(result.getInt("ROLE"));
			User user = new User(result.getString("FIRSTNAME"), result.getString("LASTNAME"), 
					result.getInt("SCORE"), result.getString("LOGIN"), result.getString("PASSWORD"), role);
			user.setId(result.getInt("USERID"));
			list.add(user);
		}
		
		return list;
	}
}
