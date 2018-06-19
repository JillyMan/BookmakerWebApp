package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.base_type.TypeBets;

public class TypeBetsDAO implements IDao<TypeBets>{

	@Override
	public void insert(TypeBets name, Connection conn) throws Exception {
		String sql = "INSERT INTO TYPE_BETS(TYPEID, NAME_BETS)"
				+ "VALUES(SQ_ORDIN_TYPE.NEXTVAL, ?)";
		
		PreparedStatement pStm = conn.prepareStatement(sql);
		pStm.setString(1, name.getTypeName());
		pStm.execute();
		pStm.close();
	}

	//TODO: TRASH METHOD ????
	@Override
	public TypeBets find(int id, Connection conn) throws Exception {		
//			String sql = "SELECT * FROM TYPE_SPORT WHERE TYPEID = ?";		
		return null;
	}

	@Override
	public List<TypeBets> select(Connection conn) throws Exception {
		
		String sql = "SELECT * FROM TYPE_BETS";
		PreparedStatement pStm = conn.prepareStatement(sql);
		ResultSet result = pStm.executeQuery();
		List<TypeBets> list = new ArrayList<TypeBets>();
		
		while(result.next()) {
			TypeBets ts = new TypeBets(result.getString("NAME_BETS"));
			ts.setId(result.getInt("TYPEID"));
			list.add(ts);
		}
		
		return list;
	}
}
