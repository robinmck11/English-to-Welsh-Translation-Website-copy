package database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by robin on 19/03/2017.
 */
public class AddTranslation
{
    private String englishNoun;
    private String welshNoun;

    private InputStream inputStream;
    private Connection conn;

    public AddTranslation(String englishNoun, String welshNoun)
    {
        this.englishNoun = englishNoun;
        this.welshNoun = welshNoun;

        inputStream = HSQLTester.class.getResourceAsStream("/database.properties");

        try
        {
            SimpleDataSource.init(inputStream);
            conn = SimpleDataSource.getConnection();

        } catch (IOException | ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }

    }

    private void insertEnglish()
    {
        try {
            Statement st = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertWelsh()
    {
        try {
            Statement st = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertTranslation()
    {
        try {
            Statement st = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
