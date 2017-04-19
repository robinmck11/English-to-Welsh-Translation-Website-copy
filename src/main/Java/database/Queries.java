package database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by robin on 19/03/2017.
 */
public class Queries
{
	private InputStream inputStream;
	private Connection conn;
	
	/**
	 * Class that handles queries used on the web application
	 */
	
	public static void main(String[] args) throws SQLException
	{
		Queries q = new Queries();
		System.out.println(q.getRandom20());
	}
	
	public Queries()
	{
		inputStream = Queries.class.getResourceAsStream("/database.properties");
		
		
		try
		{
			SimpleDataSource.init(inputStream);
			conn = SimpleDataSource.getConnection();
		} catch (IOException | ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public String[][] getRandom20() throws SQLException //todo test with data
	{
		PreparedStatement getData = conn.prepareStatement("SELECT * FROM `nouns` ORDER BY RAND() LIMIT 0,20;");
		ResultSet rs = getData.executeQuery();
		
		String[][] random20 = new String[20][3];
		
		ResultSetMetaData rsMetadata = rs.getMetaData();
		int columnCount = rsMetadata.getColumnCount();
		int x = 0;
		while (rs.next())
		{
			
			for (int i = 0; i < columnCount; i++) //todo probably change column count to 3
			{
				
				random20[x][i] = rs.getString(i + 1);
			}
			x++;
		}

		conn.close();
		return random20;

	}

	public ArrayList<String[]> getUserGrades(String userName) throws SQLException {

		PreparedStatement pS = conn.prepareStatement("SELECT * FROM test WHERE username = '" + userName + "';");
		ResultSet rS = pS.executeQuery();

		final int columnCount = 4;

		ArrayList<String[]> grades = new ArrayList<String[]>();

		while(rS.next())
		{
			String[] testGrade = new String[4];

			int rowCount = 0;

			for (int i = 0; i < columnCount; i++)
			{
				//String test = rS.getString(4);
				testGrade[i] = rS.getString(i + 1);
			}

			grades.add(rowCount,testGrade);
			rowCount++;
		}
		conn.close();
		return grades;

	}
	
	
	public void closeConnection() throws SQLException
	{
		conn.close();
	}
}
