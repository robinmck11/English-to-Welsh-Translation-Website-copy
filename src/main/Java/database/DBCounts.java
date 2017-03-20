package database;

/**
 * Created by robin on 19/03/2017.
 */

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
