/*
	Program Title:  AdminHomepageServlet
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

public class AdminHomepageServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		DBCounts dbCounts = new DBCounts();
		
		int noStudents = dbCounts.getCount("student", "username");
		int noInstructors = dbCounts.getCount("instructor", "username");
		
		request.setAttribute("noStudents", noStudents);
		request.setAttribute("noInstructors", noInstructors);
		
		request.getRequestDispatcher("/WEB-INF/adminHomepage.jsp").forward(request, response);
	}
}
