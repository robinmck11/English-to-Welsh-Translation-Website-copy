/*
	Program Title:  InstructorHomepageServlet
	Author:         Ryan O'Shea
	Created:        19/03/2017
	Version:        1.0
*/

package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBCounts;

public class StudentHomepageServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		DBCounts dbCounts = new DBCounts();
		
		int noTestsTaken = 0;
		int averageScore = 0;
		request.setAttribute("noTestsTaken", noTestsTaken);
		request.setAttribute("averageScore", averageScore);
		
		request.getRequestDispatcher("/studentHomepage.jsp").forward(request, response);
	}
}
