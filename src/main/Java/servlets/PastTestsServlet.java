/*
	Program Title:  PastTestsServlet
	Author:         Ryan O'Shea
	Created:        19/04/2017
	Version:        1.0
*/

package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Queries;

public class PastTestsServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String referrer = request.getHeader("referer");
		String redirectPage;
		
		if (referrer.contains("admin"))
			redirectPage = "/adminPastTests.jsp";
		else if (referrer.contains("instructor"))
			redirectPage = "/instructorPastTests.jsp";
		else
			redirectPage = "/pastTests.jsp";
		
		String[][] grades;
		
		Queries queries = new Queries();
		try
		{
			grades = queries.getUserGrades("student1");
			queries.closeConnection();
		} catch (SQLException e)
		{
			e.printStackTrace();
			grades = new String[0][0];
		}
		
		request.getSession().setAttribute("grades", grades);
		request.getRequestDispatcher(redirectPage).forward(request, response);
	}
}
