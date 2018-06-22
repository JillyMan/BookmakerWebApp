package com.businessLogic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.businessLogic.BetBO;
import com.domain.TypeSport;
import com.domain.User;
import com.domain.AllPlacedBets;
import com.domain.Event;
import com.domain.SpecificationBet;
import com.domain.TypeBets;
import com.jdbs.AllPlacedBetsDAO;
import com.jdbs.EventDAO;
import com.jdbs.SpecificationBetDAO;
import com.jdbs.TypeBetsDAO;

public class BetBO {
	

	public void makeBet(User user, int idEvent, String nameBet, int summa) throws Exception {
		
		if(user.getScore() > summa) {
			throw new Exception("score-user < summa-bet");
		}else {
			TypeBetsDAO typeDao = new TypeBetsDAO();
			TypeBets typeBet =  typeDao.getByName(nameBet);
			if(typeBet == null) {
				throw new Exception("ÁËßßßßßßß in Bets.makeBet() error typeBet not exist");
			}
			AllPlacedBetsDAO allBetsDao = new AllPlacedBetsDAO();
			SpecificationBetDAO specDao = new SpecificationBetDAO();
			SpecificationBet specBet = specDao.getByEventIdAndTypeBet(idEvent, typeBet.getId());
			if(specBet == null) {
				throw new Exception("Fuck spec = null");
			}
			AllPlacedBets placedBets = new AllPlacedBets(user.getId(), specBet.getId(), summa);
			System.out.println("DEBUG: Add new bet: " + placedBets.toString());
			allBetsDao.insert(placedBets);		
		}
		
	}
	
	public List<Bet> getBetsBySport(int typeid) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd");
		Date date = new Date();

		SpecificationBetDAO specDao = new SpecificationBetDAO();
		EventDAO eventDao = new EventDAO();
		List<Event> listEvent = eventDao.getAllByDateAndSport(typeid, dateFormat.format(date).toString());
		
		List<Bet> bets = new ArrayList<Bet>();

		for (Event event : listEvent) {
			List<SpecificationBet> listBets = specDao.getByEventId(event);					
			bets.add(new Bet(event, 
					listBets.get(0).getCoefficient(),
					listBets.get(1).getCoefficient(),
					listBets.get(2).getCoefficient(),
					listBets.get(3).getCoefficient(),
					listBets.get(4).getCoefficient()));
		}
		return bets;
	}	
}
