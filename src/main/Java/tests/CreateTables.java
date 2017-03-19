package tests;

import database.SimpleDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by robin on 19/03/2017.
 */
public class CreateTables
{
    private InputStream inputStream;
    private Connection conn;

    public CreateTables() throws SQLException {
        inputStream = HSQLTester.class.getResourceAsStream("/database.properties");

        try
        {
            SimpleDataSource.init(inputStream);
            conn = SimpleDataSource.getConnection();
            createTables();

        } catch (IOException | ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

    private void createTables() throws SQLException {
        Statement st = conn.createStatement();

        st.executeUpdate("CREATE TABLE student\n" +
                "(\n" +
                "username varchar(20) NOT NULL,\n" +
                " salt CHAR(20),\n" +
                " hash CHAR(128),\n" +
                " PRIMARY KEY (username)\n" +
                ");");
    }
}
