package database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Random;

/**
 * Created by sean on 21/04/17.
 */
public class AddToken {

	private InputStream inputStream;
	private Connection conn;
	public AddToken() throws SQLException
	{
		inputStream = AddNouns.class.getResourceAsStream("/database.properties");

		try
		{
			SimpleDataSource.init(inputStream);
			conn = SimpleDataSource.getConnection();


		} catch (IOException | ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			conn.close();
		}
	}

	public int generateToken(String username) throws SQLException {

		String statement = "delete FROM token where username = '"+username+"';";
		PreparedStatement preparedStatement = conn.prepareStatement(statement);
		preparedStatement.executeUpdate();
		Random rand = new Random();
		int ran = rand.nextInt(	2147483647);
		 statement = "INSERT INTO tokens  VALUES ('" + ran + "', '" + username + "', ?);";
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		preparedStatement = conn.prepareStatement(statement);
		preparedStatement.setTimestamp(1, date);
		preparedStatement.executeUpdate();

		return ran;
	}

	public  void closeConnection() throws SQLException {
		conn.close();
	}
}
