package database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

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
		inputStream = UserValidation.class.getResourceAsStream("/database.properties");
		
		
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
		return random20;
	}
	
	
	public void closeConnection() throws SQLException
	{
		conn.close();
	}
}
