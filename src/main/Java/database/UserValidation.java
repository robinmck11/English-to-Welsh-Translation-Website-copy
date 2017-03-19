package database;

import tests.HSQLTester;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by robin on 18/03/2017.
 * This class will authenticate the user by generating hashed passwords
 * The generated hash can be compared with the one stored in the database
 */

public class UserValidation
{
    InputStream inputStream;
    Connection conn;

    String dbHash;
    String dbSalt;

    String userHash;

    boolean isEqual;

    /**
     * Get connection to the database
     */

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

    /**
     * Gets the salt from the database
     * @param tableName the table to retrieve the information from
     * @param userName The user to retrieve the information from
     * @return the salt in the database
     */

    private String getDBSalt(String tableName, String userName)
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

    /**
     * Gets the has from the database for a given user
     * @param tableName Name of the table
     * @param userName name of the user
     * @return the hash stored in the database
     */

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


    /**
     * Hash's the user's input with the salt in the database
     * @param pass the user's input
     * @param tableName the table to retrieve the data from
     * @param userName the user to retrieve the data from
     * @return the users hashed password
     */

    public String userHash(String pass, String tableName, String userName)
    {
        Hash userHash = new Hash(getDBSalt(tableName, userName) + pass, false);
        return userHash.getHashString();
    }


}
