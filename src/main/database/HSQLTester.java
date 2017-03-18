package main.database;

import java.sql.*;
import java.io.*;
import java.sql.ResultSet;


public class HSQLTester
{

    public static void main(String[] args) throws IOException,ClassNotFoundException, SQLException {
        
        // This is an amended version of Horstmann’s test program.
        
        InputStream inputStream;
        
        inputStream = HSQLTester.class.getResourceAsStream("/database.properties");
        SimpleDataSource.init(inputStream);
        Connection conn = SimpleDataSource.getConnection();
        
        /*
        InputStream stream = new FileInputStream("C:\\Users\\robin\\Documents\\Yr 2 Computer Science\\Semester 2\\MiniProject1\\src\\main\\java\\com\\mycompany\\main.database.HSQLTester\\database.properties");
        SimpleDataSource.init(stream);
        Connection conn = SimpleDataSource.getConnection();
        */
        
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
