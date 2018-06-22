package com.businessLogic;

import java.util.ArrayList;
import java.util.List;

import com.domain.AllPlacedBets;
import com.domain.Event;
import com.domain.SpecificationBet;
import com.domain.TypeBets;
import com.domain.User;
import com.jdbs.AllPlacedBetsDAO;
import com.jdbs.EventDAO;
import com.jdbs.SpecificationBetDAO;
import com.jdbs.TypeBetsDAO;
import com.jdbs.UserDAO;
import com.service.exception.ServiceException;

public class UserBO {

	//TODO: Maybe TypeBetsDAO return map?
	public List<HistoryBet> getHistoryByUserId(int userId) {
		
		AllPlacedBetsDAO placedDao = new AllPlacedBetsDAO();
		TypeBetsDAO typeBets = new TypeBetsDAO();
		EventDAO eventDao = new EventDAO();
		SpecificationBetDAO specDao = new SpecificationBetDAO();
		
		List<AllPlacedBets> listPlacedBets = placedDao.getAllByKeyUserId(userId);
		List<HistoryBet> listHistory = new ArrayList<>();
				
		for (AllPlacedBets all : listPlacedBets) {
			SpecificationBet spec = specDao.getByKey(all.getBetsId());
			TypeBets type = typeBets.getByKey(spec.getTypeBetsId());
			Event event = eventDao.getByKey(spec.getEventId());
			
			listHistory.add(new HistoryBet(
					event.getNameEvent(), type.getTypeName(), spec.getCoefficient(), all.getSumma(), spec.getResult()));
		}
				
		return listHistory;
	}
	
	public User signUp(String fname, String lname, String login, String password) throws ServiceException {
		UserDAO dao = new UserDAO();

		if(dao.getByLogin(login) == true) {
			throw new ServiceException("Login already exists");			
		}		
		dao.insert(new User(fname, lname, login, password));
		User user = dao.getByLoginAndPassword(login, password);
		return user;
	}
	
	public User getUser(String login, String password) {
		UserDAO dao = new UserDAO();
		User user = dao.getByLoginAndPassword(login, password);
		return user;
	}	
}
