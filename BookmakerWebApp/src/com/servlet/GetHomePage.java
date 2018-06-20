package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class GetHomePage extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetHomePage doGet" + (new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())));
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
}
