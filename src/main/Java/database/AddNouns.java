package database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by robin on 19/03/2017.
 */
public class AddNouns
{
	private final String nounsTable = "nouns";
	
	private InputStream inputStream;
	private Connection conn;
	
	public AddNouns(String englishNoun, String welshNoun, String gender) throws SQLException
	{
		inputStream = AddNouns.class.getResourceAsStream("/database.properties");
		
		try
		{
			SimpleDataSource.init(inputStream);
			conn = SimpleDataSource.getConnection();
			
			addTranslation(englishNoun, welshNoun, gender);
		} catch (IOException | ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			conn.close();
		}
	}
	
	public void addTranslation(String english, String welsh, String gender) throws SQLException
	{
		String statement = "INSERT INTO " + nounsTable + " VALUES ('" + english + "', '" + welsh + "', '" + gender + "');";
		PreparedStatement preparedStatement = conn.prepareStatement(statement);
		preparedStatement.executeUpdate();

	}
}
