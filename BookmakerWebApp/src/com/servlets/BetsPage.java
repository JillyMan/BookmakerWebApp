package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.businessLogic.Bet;
import com.businessLogic.BetBO;
import com.domain.TypeSport;
import com.jdbs.TypeSportDAO;

@WebServlet("/bets")
public class BetsPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-> in Bets Page");
		TypeSportDAO typeSportDAO = new TypeSportDAO();
		List<TypeSport> listSport = typeSportDAO.getAll();
		request.setAttribute("listSport", listSport);	
		String tmp = request.getParameter("buttonSport");
		if(tmp!=null) {
			BetBO bets = new BetBO();
			int idsport = Integer.parseInt(tmp);
			List<Bet> listBet = bets.getBetsBySport(idsport);				
			request.setAttribute("listBet", listBet);										
		}
		
		request.getRequestDispatcher("/bets.jsp").forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in post bets");		
		request.getRequestDispatcher("/bets.jsp").forward(request, response);
	}
}
