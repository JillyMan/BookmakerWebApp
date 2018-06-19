package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.base_type.SpecificationBet;

public class SpecificationBetDAO implements IDao<SpecificationBet>{

	@Override
	public void insert(SpecificationBet name, Connection conn) throws Exception {
		String sql = "INSERT INTO SPEC_BETS(SPEC_BETSID, TYPE_BETSID, RESULT, EVENTID, COEFFICIENT)"
						+ "VALUES(SQ_ALL_BETS.NEXTVAL, ?, ?, ?, ?)";
		PreparedStatement pStm = conn.prepareStatement(sql);
		pStm.setInt(1, name.getTypebets().getId());
		pStm.setInt(2, name.getResult());		
		pStm.setInt(3, name.getEvent().getId());
		pStm.setDouble(4, name.getCoefficient());	
	}

	@Override
	public SpecificationBet find(int id, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SpecificationBet> select(Connection conn) throws Exception {
		
		return null;
	}

	
	
}
