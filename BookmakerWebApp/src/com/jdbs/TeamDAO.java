package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.base_type.Team;

public class TeamDAO implements IDao<Team>{

	@Override
	public void insert(Team name, Connection conn) throws Exception {
		String sql = "INSERT INTO TEAMS(TEAMID, TEAMNAME)"
				+ "VALUES(SQ_ORDIN_TYPE.NEXTVAL, ?)";
		
		PreparedStatement pStm = conn.prepareStatement(sql);
		pStm.setString(1, name.getNameTeam());
		pStm.execute();
		pStm.close();
	}

	//TODO: TRASH METHOD ????
	@Override
	public Team find(int id, Connection conn) throws Exception {		
//		String sql = "SELECT * FROM TYPE_SPORT WHERE TYPEID = ?";		
		return null;
	}

	@Override
	public List<Team> select(Connection conn) throws Exception {
		
		String sql = "SELECT * FROM TEAMS";
		PreparedStatement pStm = conn.prepareStatement(sql);
		ResultSet result = pStm.executeQuery();
		List<Team > list = new ArrayList<Team>();
		
		while(result.next()) {
			Team t = new Team(result.getString("TEAMNAME"));
			t.setId(result.getInt("TEAMID"));
			list.add(t);
		}
		
		return list;
	}
}
