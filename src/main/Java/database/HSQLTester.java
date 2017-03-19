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
        uV.getHash("sysadmin", "Robin");

    }
}
