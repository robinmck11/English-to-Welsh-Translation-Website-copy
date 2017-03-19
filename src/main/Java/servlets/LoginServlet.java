package servlets;

/*
	Program Title:  LoginServlet
	Author:         Ryan O'Shea
	Created:        19/03/2017
	Version:        1.0
*/

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.UserValidation;

public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// get request parameters for userID and password
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		
		UserValidation uV = new UserValidation();
		String dbHash = uV.getDBHash("sysadmin", user);
		String userHash = uV.userHash(pwd, "sysadmin", user);
		
		if (dbHash.equals(userHash))
		{
			Cookie loginCookie = new Cookie("user", user);
			//setting cookie to expiry in 30 mins
			loginCookie.setMaxAge(30 * 60);
			response.addCookie(loginCookie);
			response.sendRedirect("LoginSuccessPage.jsp");
		}
		else
		{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		}
	}
	
}