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

public class AdminHomepageServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int numberOfStudents = 2;
		int numberOfInstructors = 1;
		request.setAttribute("noStudents", numberOfStudents);
		request.setAttribute("noInstructors", numberOfInstructors);
		
		request.getRequestDispatcher("/adminHomepage.jsp").forward(request, response);
	}
}
