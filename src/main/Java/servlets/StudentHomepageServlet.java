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
		int noTestsTaken = dbCounts.getTestCount("student1");
		
		dbCounts = new DBCounts();
		
		double averageScore = dbCounts.getAvgGrade("student1");
		request.setAttribute("noTestsTaken", noTestsTaken);
		request.setAttribute("averageScore", (int)((averageScore / 20) * 100));
		
		request.getRequestDispatcher("/studentHomepage.jsp").forward(request, response);
	}
}
