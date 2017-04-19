/*
	Program Title:  StartTestServlet
	Author:         Ryan O'Shea
	Created:        19/03/2017
	Version:        1.0
*/

package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Queries;

public class StartTestServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String[][] nouns = new String[20][3];
		
		Queries queries = new Queries();
		try
		{
			nouns = queries.getRandom20();
			queries.closeConnection();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		for (int i = 0; i < nouns.length; i++)
		{
			for (int j = 0; j < nouns[0].length; j++)
				request.setAttribute("nouns" + i + j, nouns[i][j]);
		}
		request.getRequestDispatcher("/test.jsp").forward(request, response);
	}
}
