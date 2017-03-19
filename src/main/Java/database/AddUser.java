package database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Created by robin on 18/03/2017.
 */

public class AddUser
{
	InputStream inputStream;
	Connection conn;
	
	/**
	 * Connects to the database
	 * Add a user
	 */
	
	public AddUser()
	{
		inputStream = HSQLTester.class.getResourceAsStream("/database.properties");
		
		inputStream = HSQLTester.class.getResourceAsStream("/database.properties");
		
		try
		{
			SimpleDataSource.init(inputStream);
			conn = SimpleDataSource.getConnection();
			
		} catch (IOException | ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * A text interface to add a sysAdmin
	 *
	 * @throws SQLException
	 */
	
	public void addSysAdmin() throws SQLException
	{
		
		Statement st = conn.createStatement();
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("NEW SYSADMIN:");
		System.out.print("Enter username: ");
		String userName = in.next();
		System.out.print("Enter password:");
		Hash hash = new Hash(in.next(), true);
		
		try
		{
			st.executeUpdate("INSERT INTO sysadmin VALUES('" + userName + "', " + "'" + hash.getSalt() + "', " + "'" + hash.getHashString() + "');");
		} finally
		{
			st.close();
			conn.close();
		}
	}
	
	/**
	 * Add an instructor - Not tested
	 *
	 * @param userName
	 * @param password
	 * @throws SQLException
	 */
	
	public void addInstructor(String userName, String password) throws SQLException
	{
		Statement st = conn.createStatement();
		
		Hash hash = new Hash(password, true);
		
		try
		{
			st.executeUpdate("INSERT INTO instructor VALUES('" + userName + "', " + "'" + hash.getSalt() + "', " + "'" + hash.getHashString() + "');");
		} finally
		{
			st.close();
			conn.close();
		}
	}
	
	/**
	 * Add a student - Not Tested
	 *
	 * @param userName
	 * @param password
	 * @throws SQLException
	 */
	
	public void addStudent(String userName, String password) throws SQLException
	{
		Statement st = conn.createStatement();
		
		Hash hash = new Hash(password, true);
		
		try
		{
			st.executeUpdate("INSERT INTO student VALUES('" + userName + "', " + "'" + hash.getSalt() + "', " + "'" + hash.getHashString() + "');");
		} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e)
		{
			// HANDLE THIS GRACEFULLY - Prompt user to choose another username -
			System.out.println("USERNAME ALREADY EXISTS!!");
		} finally
		{
			st.close();
			conn.close();
		}
	}
}
