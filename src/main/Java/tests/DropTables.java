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
public class DropTables
{
    private InputStream inputStream;
    private Connection conn;

    private String englishNoun = "englishnoun";
    private String instructor = "instructor";
    private String student = "student";
    private String sysAdmin = "sysadmin";
    private String test = "test";
    private String translation = "translation";
    private String welshNoun = "welshnoun";

    public DropTables() throws SQLException
    {
        inputStream = DropTables.class.getResourceAsStream("/database.properties");

        try
        {
            SimpleDataSource.init(inputStream);
            conn = SimpleDataSource.getConnection();
            dropTables();

        } catch (IOException | ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        } finally {
            conn.close();
        }


    }

    private void dropTables() throws SQLException {
        Statement st = conn.createStatement();

        try {
            st.executeUpdate("DROP TABLE IF EXISTS " + translation);
            st.executeUpdate("DROP TABLE IF EXISTS " + test);
            st.executeUpdate("DROP TABLE IF EXISTS " + englishNoun);
            st.executeUpdate("DROP TABLE IF EXISTS " + instructor);
            st.executeUpdate("DROP TABLE IF EXISTS " + student);
            st.executeUpdate("DROP TABLE IF EXISTS " + sysAdmin);
            st.executeUpdate("DROP TABLE IF EXISTS " + welshNoun);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally
        {
            st.close();
        }


    }
}
