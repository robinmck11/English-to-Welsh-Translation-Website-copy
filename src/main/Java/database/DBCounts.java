package database;

/**
 * Created by robin on 19/03/2017.
 */

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

/**
 *  Retrieve the count for rows in a table
 */
public class DBCounts
{
    private InputStream inputStream;
    private Connection conn;

    private String count;

    public DBCounts()
    {
        inputStream = DBCounts.class.getResourceAsStream("/database.properties");

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
     * Gets the count for a given table
     * @param tableName the name of the table
     * @return the count
     */
    public int getCount(String tableName, String field)
    {
		try
		{
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT count(" + field + ") FROM " + tableName + ";");
			
			while(rs.next())
				count = rs.getString(1);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
        return Integer.parseInt(count);
    }

    /**
     *
     * @param username the username of the student
     * @return the number of tests taken by that user
     */

    public String getTestCount(String username)
    {
        String userTestCount = null;

        try {

            PreparedStatement pS = conn.prepareStatement("SELECT count(username) FROM test WHERE username = '" + username + "';");
            ResultSet rS = pS.executeQuery();

            while(rS.next())
            {
                userTestCount = rS.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userTestCount;
    }

    /**
     *
     * @param username the sutudents username
     * @return the average grade
     */

    public String getAvgGrade(String username)
    {

        String avgGrade = null;

        try {

            PreparedStatement pS = conn.prepareStatement("SELECT format(avg(grade),2) FROM test WHERE username = '" + username + "';");
            ResultSet rS = pS.executeQuery();

            while (rS.next())
            {
                avgGrade = rS.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return avgGrade;

    }
}
