/*
	Program Title:  ManageWordServlet
	Author:         Ryan O'Shea
	Created:        19/03/2017
	Version:        1.0
*/

package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.AddNouns;

public class ManageWordServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String submitType = request.getParameter("submit");
		
		if (submitType.equalsIgnoreCase("Add"))
		{
			String welshNoun = request.getParameter("welshNoun");
			String englishNoun = request.getParameter("englishNoun");
			try
			{
				new AddNouns(englishNoun, welshNoun);
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		else if (submitType.equalsIgnoreCase("Remove"))
		{
			String welshNoun = request.getParameter("welshNoun");
//			try
//			{
//				new AddNouns(englishNoun, welshNoun);
//			} catch (SQLException e)
//			{
//				e.printStackTrace();
//			}
		}
		else if (submitType.equalsIgnoreCase("Update"))
		{
			String welshNounOriginal = request.getParameter("welshNounOriginal");
			String welshNounNew = request.getParameter("welshNounNew");
			String englishNounOriginal = request.getParameter("englishNounOriginal");
			String englishNounNew = request.getParameter("englishNounNew");
//			try
//			{
//				new AddNouns(englishNoun, welshNoun);
//			} catch (SQLException e)
//			{
//				e.printStackTrace();
//			}
		}
		
		request.getRequestDispatcher("/manageWords.jsp").forward(request, response);
	}
}
