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
		String username= "";
		try
		{
			grade = Integer.parseInt(request.getParameter("score"));
			username = request.getParameter("username");
		} catch (Exception e) {
			System.out.println("hey");
		}
		
		InsertGrade insertGrade = new InsertGrade(grade, username);
		insertGrade.insertGrade();
		
		response.sendRedirect("PastTestsServlet");
	}
}
