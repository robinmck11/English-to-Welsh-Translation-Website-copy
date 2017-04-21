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
import database.RemoveRecord;

public class ManageAccountServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String submitType = request.getParameter("submit");
		
		if (submitType.equalsIgnoreCase("Add Student"))
		{
			String studentUsername = request.getParameter("studentUsername");
			String studentPassword = request.getParameter("studentPassword");
			try
			{
				new AddUser().addStudent(studentUsername, studentPassword);
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		else if (submitType.equalsIgnoreCase("Remove Student"))
		{
			String studentUsername = request.getParameter("studentUsername");
			RemoveRecord removeRecord = new RemoveRecord();
			removeRecord.removeRecord("student", "username", studentUsername);
		}
		else if (submitType.equalsIgnoreCase("Add Instructor"))
		{
			String instructorUsername = request.getParameter("instructorUsername");
			String instructorPassword = request.getParameter("instructorPassword");
			try
			{
				new AddUser().addInstructor(instructorUsername, instructorPassword);
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		else if (submitType.equalsIgnoreCase("Remove Instructor"))
		{
			String instructorUsername = request.getParameter("instructorUsername");
			RemoveRecord removeRecord = new RemoveRecord();
			removeRecord.removeRecord("instructor", "username", instructorUsername);
		}
		
		request.getRequestDispatcher("/manageAccounts.jsp").forward(request, response);
	}
}
