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

public class InstructorHomepageServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int noWords = new DBCounts().getCount("englishNoun", "englishNoun");
		request.setAttribute("noWords", noWords);
		
		request.getRequestDispatcher("/instructorHomepage.jsp").forward(request, response);
	}
}
