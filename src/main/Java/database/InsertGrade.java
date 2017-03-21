package database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by robin on 19/03/2017.
 */

public class InsertGrade
{
    private int grade;
    String timeGained;
    String dateGained;

    private String userName;
    private final String tableName;

    private InputStream inputStream;
    private Connection conn;

    public InsertGrade(int grade, String userName)
    {
        this.grade = grade;
        this.userName = userName;
        tableName = "test";

        Date date = new Date();

        SimpleDateFormat sDF1 = new SimpleDateFormat("yyyy.MM.dd");
        SimpleDateFormat sDF2 = new SimpleDateFormat("hh:mm:ss");

        dateGained = sDF1.format(date);
        timeGained = sDF2.format(date);

        inputStream = InsertGrade.class.getResourceAsStream("/database.properties");

        try
        {
            SimpleDataSource.init(inputStream);
            conn = SimpleDataSource.getConnection();

        } catch (IOException | ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }

    }

    public void insertGrade()
    {
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO test VALUES('" + userName + "'," + grade + "," + "'" + dateGained + "'," + "'" + timeGained + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
