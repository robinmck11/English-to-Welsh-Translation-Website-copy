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

    /**
     * A text interface to add a sysAdmin
     * @throws SQLException
     */

    public void addSysAdmin() throws SQLException
    {

        Statement st = conn.createStatement();

        Scanner in = new Scanner(System.in);

        System.out.println("NEW SYSADMIN:");
        System.out.print("Enter PK: ");
        String pk = in.next();
        System.out.print("Enter username: ");
        String userName = in.next();
        System.out.print("Enter password:");
        Hash hash = new Hash(in.next());

        try
        {
            st.executeUpdate("INSERT INTO sysadmin VALUES(" + pk + ", " + "'" + userName + "', "  + "'" + hash.getSalt() + "', " + "'" + hash.getHashString() + "');");
        }
        finally
        {
            st.close();
            conn.close();
        }
    }
}
