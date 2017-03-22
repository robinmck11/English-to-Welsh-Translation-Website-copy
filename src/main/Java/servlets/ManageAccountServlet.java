/*
	Program Title:  ManageAccountServlet
	Author:         Ryan O'Shea
	Created:        21/03/2017
	Version:        1.0
*/

package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.AddUser;

public class ManageAccountServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String submitType = request.getParameter("submit");
		
		if (submitType.equalsIgnoreCase("Add Student"))
		{
			String studentName = request.getParameter("studentName");
			String studentUsername = request.getParameter("studentUsername");
			try
			{
				new AddUser().addStudent(studentName, studentUsername);
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		else if (submitType.equalsIgnoreCase("Remove Student"))
		{
			String studentUsername = request.getParameter("studentUsername");
//			try
//			{
//				new AddUser(englishNoun, welshNoun);
//			} catch (SQLException e)
//			{
//				e.printStackTrace();
//			}
		}
		else if (submitType.equalsIgnoreCase("Add Instructor"))
		{
			String instructorName = request.getParameter("instructorName");
			String instructorUsername = request.getParameter("instructorUsername");
			try
			{
				new AddUser().addInstructor(instructorName, instructorUsername);
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		else if (submitType.equalsIgnoreCase("Remove Instructor"))
		{
			String instructorUsername = request.getParameter("instructorUsername");
//			try
//			{
//				new AddNouns(englishNoun, welshNoun);
//			} catch (SQLException e)
//			{
//				e.printStackTrace();
//			}
		}
		
		request.getRequestDispatcher("/manageAccounts.jsp").forward(request, response);
	}
}
