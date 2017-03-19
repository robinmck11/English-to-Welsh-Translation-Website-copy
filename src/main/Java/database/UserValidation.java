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
public class UserValidation
{
    InputStream inputStream;
    Connection conn;

    String dbHash;
    String dbSalt;

    boolean isEqual;

    public UserValidation()
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

    public String getDBSalt(String tableName, String userName)
    {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT salt FROM " + tableName + " WHERE username = '" + userName + "';");

            while (rs.next()){
                dbSalt = rs.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dbSalt;
    }


    public String getDBHash(String tableName, String userName)
    {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT hash FROM " + tableName + " WHERE username = '" + userName + "';");

            while (rs.next()){
                dbHash = rs.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dbHash;
    }

    public String userHash(String pass)
    {
        Hash userHash = new Hash(pass);
        return userHash.getHashString();
    }

    /*

    public boolean compareHashes()
    {}

    */


}
