package database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by robin on 18/03/2017.
 */

public class AddUser
{
    InputStream inputStream;
    Connection conn;

    public AddUser()
    {
        inputStream = HSQLTester.class.getResourceAsStream("/database.properties");

        inputStream = HSQLTester.class.getResourceAsStream("/database.properties");

        try {

            SimpleDataSource.init(inputStream);
            conn = SimpleDataSource.getConnection();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void test() throws SQLException
    {

        Statement st = conn.createStatement();

        try
        {
            st.execute("CREATE TABLE IF NOT EXISTS accounts(balance DECIMAL(5, 2))");
            st.execute("INSERT INTO accounts VALUES (999.99)");
            st.execute("INSERT INTO accounts VALUES (666.66)");

            ResultSet rs = st.executeQuery("SELECT * FROM accounts");

            while (rs.next())
            {
                System.out.println(rs.getString("balance"));
            }

            st.execute("DROP TABLE accounts");
        }
        finally
        {
            System.out.println("Table created and then dropped!");
            st.close();
            conn.close();
        }
    }
}
