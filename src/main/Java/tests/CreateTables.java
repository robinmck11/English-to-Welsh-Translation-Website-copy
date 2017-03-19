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
        inputStream = CreateTables.class.getResourceAsStream("/database.properties");

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

        st.executeUpdate("CREATE TABLE test\n" +
                "(username varchar(20) NOT NULL,\n" +
                " grade INTEGER(10),\n" +
                " dateGained date NOT NULL,\n" +
                " timeGained time NOT NULL,\n" +
                " PRIMARY KEY (username, dateGained, timeGained),\n" +
                " FOREIGN KEY (username) REFERENCES student (username) ON UPDATE CASCADE ON DELETE CASCADE\n" +
                ");");

        st.executeUpdate("CREATE TABLE englishNoun\n" +
                "(\n" +
                "englishNoun VARCHAR(30) NOT NULL,\n" +
                " PRIMARY KEY (englishNoun)\n" +
                ");");

        st.executeUpdate("CREATE TABLE welshNoun\n" +
                "(\n" +
                " welshNoun VARCHAR(30) NOT NULL,\n" +
                " PRIMARY KEY (welshNoun)\n" +
                ");");

        st.executeUpdate("CREATE TABLE translation\n" +
                "(\n" +
                "englishNoun VARCHAR(30) NOT NULL,\n" +
                " welshNoun VARCHAR(30) NOT NULL,\n" +
                " PRIMARY KEY (englishNoun, welshNoun),\n" +
                " FOREIGN KEY (englishNoun) REFERENCES englishNoun (englishNoun) ON UPDATE CASCADE ON DELETE CASCADE,\n" +
                " FOREIGN KEY (welshNoun) REFERENCES welshNoun (welshNoun) ON UPDATE CASCADE ON DELETE CASCADE\n" +
                ");");

        st.executeUpdate("CREATE TABLE instructor\n" +
                "(\n" +
                "username VARCHAR(20) NOT NULL,\n" +
                " salt CHAR(20),\n" +
                " hash CHAR(128),\n" +
                " PRIMARY KEY (username)\n" +
                ");");

        st.executeUpdate("CREATE TABLE sysAdmin\n" +
                "(\n" +
                "username VARCHAR(20) NOT NULL,\n" +
                " salt CHAR (20),\n" +
                " hash CHAR (128), PRIMARY KEY (username)\n" +
                ");");
    }
}
