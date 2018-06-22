package com.servlets.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.domain.User;
import com.jdbs.UserDAO;

public class UserFilter implements Filter {

    public UserFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		boolean userOnline = false;
		User user = (User)((HttpServletRequest)request).getSession().getAttribute("user");
		
		if(user != null) {
			UserDAO dao = new UserDAO();
			User tmp = dao.getByLoginAndPassword(user.getLogin(), user.getPassword());
			if(tmp != null) {
				userOnline = true;
			}
		}
		System.out.println("oserOnline: " + userOnline);		
		request.setAttribute("userOnline", userOnline);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
