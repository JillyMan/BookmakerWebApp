package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.businessLogic.UserBO;
import com.domain.User;
import com.service.exception.ServiceException;

@WebServlet("/signUp")
@SuppressWarnings("serial")
public class SignUp extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		System.out.println("\t in post Sign Up");
		UserBO bo = new UserBO();
		try {
			User user = bo.signUp(fname, lname, login, password);
			request.getSession().setAttribute("user", user);
		} catch (ServiceException e) {
			request.setAttribute("typeMessage", "alert alert-danger");
			request.setAttribute("message", "login already exist, please input new login");
			e.printStackTrace();
		}
		response.sendRedirect("load?page=home");
	}
}
