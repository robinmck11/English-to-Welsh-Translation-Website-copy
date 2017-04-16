/*
	Program Title:  StartTestServlet
	Author:         Ryan O'Shea
	Created:        19/03/2017
	Version:        1.0
*/

package servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBCounts;

public class StartTestServlet extends HttpServlet
{
	private int[] randomIndexes;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		randomIndexes = new int[20];
		
		String[] englishWords = new String[20];
		String[] welshWords = new String[20];
		
		Random random = new Random();
		DBCounts dbCounts = new DBCounts();
		
		for (int i = 0; i < 20; i++)
		{
			int randomIndex = random.nextInt(dbCounts.getCount("nouns", "welshNoun") + 1);
			
			if (!checkIfDuplicate(randomIndex))
			{
				randomIndexes[i] = randomIndex;
				// get english word at index and add to englishWords string array
				// get welsh word at index and add to welshWords string array
			}
			else
				i--;
		}
	}
	
	private boolean checkIfDuplicate(int newRandomIndex)
	{
		boolean duplicate = false;
		
		for (int randomIndex : randomIndexes)
		{
			if (randomIndex == newRandomIndex)
				duplicate = true;
		}
		
		return duplicate;
	}
}
