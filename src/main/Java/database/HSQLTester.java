/*
	Program Title:  HSQLTester
	Author:         Robin McKenna
	Created:        18/03/2017
	Version:        1.0
*/

package database;

import java.sql.*;
import java.io.*;
import java.sql.ResultSet;

public class HSQLTester
{

    public static void main(String[] args) throws IOException,ClassNotFoundException, SQLException {

        // Test add admin
        UserValidation uV = new UserValidation();

        String dbHash = uV.getDBHash("sysadmin","robin");
        String userHash = uV.userHash("abc", "sysadmin", "robin");

        System.out.println(dbHash);
        System.out.println(userHash);

        if (dbHash.equals(userHash))
        {
            System.out.println("EQUAL");
        }
        else
            System.out.println("NOT EQUAL");

    }
}
