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
		int noStudents = 2;
		int noInstructors = 1;
		request.setAttribute("noStudents", noStudents);
		request.setAttribute("noInstructors", noInstructors);
		
		request.getRequestDispatcher("/WEB-INF/adminHomepage.jsp").forward(request, response);
	}
}
