/*
	Program Title:  FinishTestServlet
	Author:         Ryan O'Shea
	Created:        21/03/2017
	Version:        1.0
*/

package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FinishTestServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int noCorrectAnswers = Integer.parseInt(request.getParameter("noCorrectAnswers"));
		int noIncorrectAnswers = 20 - noCorrectAnswers;
		
		
	}
}
