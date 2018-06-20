package com.servlet.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domain.User;
import com.domain.enums.Role;
import com.jdbs.UserDAO;
import com.jdbs.oracledb.OracleConnector;

public class AuthFilter implements Filter {

	@Override
	public void destroy() {	}

	@Override
	public void init(FilterConfig filterConfig ) throws ServletException {}

//	@Override
//	public void doFilter(ServletRequest req, ServletResponse resp , FilterChain filterChain)
//			throws IOException, ServletException {
//		
//		HttpServletRequest request = (HttpServletRequest)req;
//		HttpServletResponse response = (HttpServletResponse)resp;
//		
//		String login = request.getParameter("login");
//		String password = request.getParameter("password");
//		
//		Connection conn = null;
//		try {
//			HttpSession session = request.getSession();
//			conn = OracleConnector.getInstance().getConnection();
//			
//			if(session != null && session.getAttribute("login") != null && session.getAttribute("password") != null) {
//				Role role = (Role)session.getAttribute("role");
//				moveToMenu(request, response, role);
//			}
//			else {
//				User user = new User();
//				if(user != null) {
//					session.setAttribute("name", user.getFirstName() + " " + user.getLastName());
//					session.setAttribute("login", user.getLogin());
//					session.setAttribute("password", user.getPassword());
//					session.setAttribute("score", user.getLogin());
//					//moveToMenu(request, response, user.getRole());
//				} else {
//					moveToMenu(request, response, Role.UNKNOWN);
//				}			
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();			
//		}finally {
//			try {
//				if(conn != null) {
//					conn.close();
//				}
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//	}
	
	private void moveToMenu(HttpServletRequest request, HttpServletResponse response, Role role) throws ServletException, IOException {
		if(role == Role.ADMIN) {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} 
		else if(role == Role.BOOKMAKER) {
			request.getRequestDispatcher("home.jsp").forward(request, response);			
		}
		else if(role == Role.USER) {
			request.getRequestDispatcher("home.jsp").forward(request, response);

		}
		else if(role == Role.UNKNOWN){
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}	
}