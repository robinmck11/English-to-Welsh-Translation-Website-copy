package servlets;

/*
	Program Title:  LoginServlet
	Author:         Ryan O'Shea
	Created:        19/03/2017
	Version:        1.0
*/

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.AddToken;
import database.UserValidation;

public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String referrer = request.getHeader("referer");
		String tableName = "";
		String redirectPage = "";
		String cookieType = "";

		if (referrer.contains("adminLogin"))
		{
			tableName = "sysAdmin";
			redirectPage = "AdminHomepageServlet";
			cookieType = "admin";

		}
		else if (referrer.contains("studentLogin"))
		{
			tableName = "student";
			redirectPage = "StudentHomepageServlet";
			cookieType = "user";
		}
		else if (referrer.contains("instructorLogin"))
		{
			tableName = "instructor";
			redirectPage = "InstructorHomepageServlet";
			cookieType = "instructor";
		}
		
		// get request parameters for userID and password
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		
		String dbHash = "";
		
		UserValidation uV = new UserValidation();
		if (uV.getDBHash(tableName, user) != null)
			dbHash = uV.getDBHash(tableName, user);
		String userHash = uV.userHash(pwd, tableName, user);
		
		if (dbHash.equals(userHash))
		{
			String token= "";

			try {
				AddToken addToken = new AddToken();
				token = Integer.toString( addToken.generateToken(user));
				addToken.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			Cookie loginCookie = new Cookie(cookieType, token);
			//setting cookie to expiry in 30 mins
			loginCookie.setMaxAge(30 * 60);
			
			HttpSession httpSession = request.getSession();

			httpSession.setAttribute("username",token);

			response.addCookie(loginCookie);
			response.sendRedirect(redirectPage);
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<html><body>");
			out.println("<img src=\"meme.jpg\" style=\"display: block;margin: 0 auto;\">");
			out.println("</html></body>");
			
			out.close();
			
//			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
//			PrintWriter out = response.getWriter();
//			out.println("<font color=red>Either user name or password is wrong.</font>");
//			rd.include(request, response);
		}
	}
}