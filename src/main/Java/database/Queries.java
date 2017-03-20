package database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by robin on 19/03/2017.
 */
public class Queries
{
    private InputStream inputStream;
    private Connection conn;

    /**
     *  Class that handles queries used on the web application
     */

    public Queries()
    {
        inputStream = UserValidation.class.getResourceAsStream("/database.properties");


        try {
            SimpleDataSource.init(inputStream);
            conn = SimpleDataSource.getConnection();
        } catch (IOException | ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
    }





    public void closeConnection() throws SQLException {
        conn.close();
    }
}
