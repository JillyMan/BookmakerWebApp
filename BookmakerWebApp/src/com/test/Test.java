package com.test;

import java.util.List;
import java.sql.Connection;

import com.domain.*;
import com.domain.enums.Role;
import com.domain.enums.StatusBets;
import com.jdbs.*;
import com.jdbs.interfaces.GenericDao;
import java.sql.Timestamp;

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
		dao.insert(new TypeSport("LOL"));

		List<TypeSport> list = dao.getAll();		
		TypeSport t = dao.getByKey(list.get(list.size() - 1).getId());
		
		for(TypeSport l : list) {
			System.out.println(l.toString());
		}		
		System.out.println(t.toString());
	}

	public void typeBets() {
		TypeBetsDAO dao = new TypeBetsDAO();
		List<TypeBets> list = dao.getAll();
		dao.insert(new TypeBets("TestBet"));
		TypeBets t = dao.getByKey(list.get(list.size() - 1).getId());
		
		for(TypeBets l : list) {
			System.out.println(l.toString());
		}		
		System.out.println(t.toString());
	}

	public void typeTeam() {
		TeamDAO dao = new TeamDAO();
		List<Team> list = dao.getAll();
		dao.insert(new Team("testTeam"));
			
		Team t = dao.getByKey(list.get(list.size() - 1).getId());
				
		for(Team l : list) {
			System.out.println(l.toString());
		}		
		System.out.println(t.toString());
	}	

	public void testSpecificationBet() {
		SpecificationBetDAO dao = new SpecificationBetDAO();
		List<SpecificationBet> list = dao.getAll();

		dao.insert(new SpecificationBet(1, 1.2, StatusBets.NONE, 4));
		SpecificationBet t = dao.getByKey((list.get(list.size() - 1).getId()));
		
		for(SpecificationBet l : list) {
			System.out.println(l.toString());
		}		
		System.out.println(t.toString());
	}	
	
	@SuppressWarnings("deprecation")
	public void testEvent() {
		EventDAO dao = new EventDAO();
		List<Event> list = dao.getAll();

		dao.insert(new Event("Event#10", new Timestamp(2019, 11, 13, 13, 0, 0, 0), 3));
		Event e = dao.getByKey(list.get(list.size() - 1).getId());
		
		for(Event l : list) {
			System.out.println(l.toString());
		}		
		System.out.println(e.toString());
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
		//test.users();
		//test.typeSport();		
		//test.typeBets();
		//test.typeTeam();
		//test.testSpecificationBet();
		//test.testEvent();
		//test.testContest();
		//test.testAllPlacedBets();

	}	
}