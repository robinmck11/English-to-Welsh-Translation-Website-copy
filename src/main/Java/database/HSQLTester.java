package database;

import java.sql.*;
import java.io.*;
import java.sql.ResultSet;


public class HSQLTester
{

    public static void main(String[] args) throws IOException,ClassNotFoundException, SQLException {

        // Test
        AddUser test1 = new AddUser();
        test1.addSysAdmin();

    }
}
