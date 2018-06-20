package com;

import java.util.List;
import java.sql.Connection;
import com.dao.*;
import com.base_type.*;
import com.connector.ConnectorToDB;

public class test {
	public static void main(String[] args) throws Exception {
		Connection conn = ConnectorToDB.getInstatnce().getConnection("artyomRoot", "toor");		 
		
		TeamDAO td = new TeamDAO();
		List<Team> list = td.select(conn);
		
		for(Team t: list) {
			System.out.println(t.getId() + t.getNameTeam());
		}	
		
		/*TypeSportDAO tsd = new TypeSportDAO();
		TypeBetsDAO tbd = new TypeBetsDAO();
		List<TypeBets> list = tbd.select(conn);
		
		for(TypeBets ts : list) {
			System.out.println(ts.getId() + ts.getTypeName());
		}	
		List<TypeSport> list = tsd.select(conn);
		
		for(TypeSport ts : list) {
			System.out.println(ts.getId() + ts.getTypeName());
		}	

		UserDAO userDao = new UserDAO();		
		List<User> list = userDao.select(conn);		
		
		for(User user : list) {
			System.out.println(user.toString());
		} */	
	}
}
