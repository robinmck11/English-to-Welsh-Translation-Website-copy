/*
	Program Title:  FinishTestServlet
	Author:         Ryan O'Shea
	Created:        21/03/2017
	Version:        1.0
*/

package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.InsertGrade;

public class FinishTestServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int grade = 0;
		try
		{
			grade = Integer.parseInt(request.getParameter("score"));
		} catch (Exception e) {}
		
		InsertGrade insertGrade = new InsertGrade(grade, "student1");
		insertGrade.insertGrade();
		
		response.sendRedirect("PastTestsServlet");
	}
}
