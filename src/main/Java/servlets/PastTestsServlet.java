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
		
		for (int i = 0; i < grades.length; i++)
		{
			for (int j = 1; j < 3; j++)
				grades[i][j] = grades[i][j];
		}
		
		request.getSession().setAttribute("grades", grades);
		request.getRequestDispatcher("/pastTests.jsp").forward(request, response);
	}
}