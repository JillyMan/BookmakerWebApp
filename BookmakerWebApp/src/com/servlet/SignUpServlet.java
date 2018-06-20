package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignUpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {				
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
//		HttpSession session = request.getSession();
		
		String fname = (String)request.getAttribute("fname");
		String lname = (String)request.getAttribute("lname");
		String login = (String)request.getAttribute("login");
		String password = (String)request.getAttribute("password");	

		
		
		response.sendRedirect("/home");
	}	
}
