package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.businessLogic.HistoryBet;
import com.businessLogic.UserBO;
import com.domain.User;

@SuppressWarnings("serial")
@WebServlet("/profile")
public class Profile extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("-> Profile");
		
		UserBO userBo = new UserBO();
		User user = (User)request.getSession().getAttribute("user");
		List<HistoryBet> historyBet = userBo.getHistoryByUserId(user.getId());					
		request.setAttribute("historyBet", historyBet);
		
		System.out.println("User ->\t" + user.toString());
		
		request.getRequestDispatcher("/profile.jsp").forward(request, response);
	}	
}
