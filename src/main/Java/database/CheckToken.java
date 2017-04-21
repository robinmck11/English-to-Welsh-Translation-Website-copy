package database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by sean on 21/04/17.
 */
public class CheckToken
{
	private InputStream inputStream;
	private Connection conn;
	public CheckToken() throws SQLException
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

	public String verifyToken(int token) throws SQLException
	{

		PreparedStatement pS = conn.prepareStatement("SELECT username FROM tokens WHERE idtokens = '" + token + "';");
		ResultSet rS = pS.executeQuery();

		String username = "";

		rS.next();
		username = rS.getString(1);


		return username;


	}

	public  void closeConnection() throws SQLException {
		conn.close();
	}
}
