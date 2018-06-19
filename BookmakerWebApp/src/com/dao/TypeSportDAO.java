package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.base_type.TypeSport;

public class TypeSportDAO implements IDao<TypeSport>{

	@Override
	public void insert(TypeSport name, Connection conn) throws Exception {
		String sql = "INSERT INTO TYPE_SPORT(TYPEID, TYPE_NAME)"
				+ "VALUES(SQ_TYPE_SPORT.NEXTVAL, ?)";
		
		PreparedStatement pStm = conn.prepareStatement(sql);
		pStm.setString(1, name.getTypeName());
		pStm.execute();
		pStm.close();
	}

	//TODO: TRASH METHOD ????
	@Override
	public TypeSport find(int id, Connection conn) throws Exception {		
//		String sql = "SELECT * FROM TYPE_SPORT WHERE TYPEID = ?";		
		return null;
	}

	@Override
	public List<TypeSport> select(Connection conn) throws Exception {
		
		String sql = "SELECT * FROM TYPE_SPORT";
		PreparedStatement pStm = conn.prepareStatement(sql);
		ResultSet result = pStm.executeQuery();
		List<TypeSport> list = new ArrayList<TypeSport>();
		
		while(result.next()) {
			TypeSport ts = new TypeSport(result.getString("TYPE_NAME"));
			ts.setId(result.getInt("TYPEID"));
			list.add(ts);
		}
		
		return list;
	}
}
