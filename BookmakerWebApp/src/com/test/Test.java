package com.test;

import java.util.List;
import java.sql.Connection;

import com.domain.*;
import com.domain.enums.Role;
import com.jdbs.*;
import com.jdbs.interfaces.GenericDao;

public class Test {

	public void users() {
		UserDAO dao = new UserDAO();
		
		List<User> list = dao.getAll();
		User u = list.get(list.size() - 1);
		dao.delete(u);
		list = dao.getAll();

		for(User l : list) {
			System.out.println(l.toString());
		}
		
		u = dao.getByKey("test9");
		System.out.println(u.toString());
	}
	
	public void typeSport() {
		TypeSportDAO dao = new TypeSportDAO();
		List<TypeSport> list = dao.getAll();
		
		for(TypeSport l : list) {
			System.out.println(l.toString());
		}		
	}

	public void typeBets() {
		TypeBetsDAO dao = new TypeBetsDAO();
		List<TypeBets> list = dao.getAll();
		
		for(TypeBets l : list) {
			System.out.println(l.toString());
		}		
	}

	public void typeTeam() {
		TeamDAO dao = new TeamDAO();
		List<Team> list = dao.getAll();
		
		for(Team l : list) {
			System.out.println(l.toString());
		}		
	}	

	public void testSpecificationBet() {
		SpecificationBetDAO dao = new SpecificationBetDAO();
		List<SpecificationBet> list = dao.getAll();
		
		for(SpecificationBet l : list) {
			System.out.println(l.toString());
		}		
	}	
	
	public void testEvent() {
		EventDAO dao = new EventDAO();
		List<Event> list = dao.getAll();
		
		for(Event l : list) {
			System.out.println(l.toString());
		}		
	}	
	
	public void testContest() {
		ContestDAO dao = new ContestDAO();
		List<Contest> list = dao.getAll();
		
		for(Contest l : list) {
			System.out.println(l.toString());
		}		
	}	
	
	public void testAllPlacedBets() {
		AllPlacedBetsDAO dao = new AllPlacedBetsDAO();
		List<AllPlacedBets> list = dao.getAll();
		
		for(AllPlacedBets l : list) {
			System.out.println(l.toString());
		}		
	}	
	
	public static void main(String[] args) throws Exception {
		Test test = new Test();		
		test.users();
		//test.typeSport();		
		//test.typeBets();
		//test.typeTeam();
		//test.SpecificationBet();
		//test.testEvent();
		//test.testContest();
		//test.testAllPlacedBets();

	}	
}