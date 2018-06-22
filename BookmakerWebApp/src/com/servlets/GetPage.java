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

@WebServlet("/load")
@SuppressWarnings("serial")
public class GetPage extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jspPage = "index";
		String page = request.getParameter("page");
		
		if(page!=null && !page.equals("")) {
			if(page.equals("signIn")) {
				jspPage = "signIn";
			}
			
			if(page.equals("signUp")) {
				jspPage = "signUp";
			}
			
			if(page.equals("about")) {
				jspPage = "about";
			}

			if(page.equals("withdrawMoney")) {
				
				jspPage = "withdrawMoney";
			}
			
			if(page.equals("refill")) {
				jspPage = "refill";				
			}

			if(page.equals("signOut")) {
				request.getSession().removeAttribute("user");
				request.setAttribute("userOnline", false);
			}
		}
		System.out.println("go to" + jspPage);
		request.getRequestDispatcher("/"+jspPage+".jsp").forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}	
}
