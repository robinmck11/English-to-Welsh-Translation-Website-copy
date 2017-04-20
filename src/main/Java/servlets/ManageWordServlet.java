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
import database.RemoveRecord;
import database.UpdateNouns;

public class ManageWordServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String submitType = request.getParameter("submit");
		
		if (submitType.equalsIgnoreCase("Add"))
		{
			String welshNoun = request.getParameter("welshNoun");
			String englishNoun = request.getParameter("englishNoun");
			String gender = request.getParameter("gender").toLowerCase();
			
			try
			{
				new AddNouns(englishNoun, welshNoun, gender);
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		else if (submitType.equalsIgnoreCase("Remove"))
		{
			String welshNoun = request.getParameter("welshNoun");
			RemoveRecord removeRecord = new RemoveRecord();
			removeRecord.removeRecord("nouns", "welshNoun", welshNoun);
		}
		else if (submitType.equalsIgnoreCase("Update"))
		{
			String welshNounOriginal = request.getParameter("welshNounOriginal");
			String welshNounNew = request.getParameter("welshNounNew");
			String englishNounOriginal = request.getParameter("englishNounOriginal");
			String englishNounNew = request.getParameter("englishNounNew");
			String gender = request.getParameter("gender").toLowerCase();
			
			UpdateNouns updateNouns = new UpdateNouns();
			updateNouns.updateNouns(englishNounOriginal, welshNounOriginal, englishNounNew, welshNounNew);
		}
		
		request.getRequestDispatcher("/manageWords.jsp").forward(request, response);
	}
}
