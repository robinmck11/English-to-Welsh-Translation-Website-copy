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

import database.CheckToken;
import database.Queries;

public class PastTestsServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("username");



		Queries queries = new Queries();
		String[][] grades;
		
		try
		{
			grades = queries.getUserGrades(username);
			queries.closeConnection();
		} catch (SQLException e)
		{
			e.printStackTrace();
			grades = new String[0][0];
		}
		
		request.getSession().setAttribute("grades", grades);
		request.getRequestDispatcher("/pastTests.jsp").forward(request, response);
	}
}
