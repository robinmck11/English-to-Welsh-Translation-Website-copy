package database;

import javax.swing.plaf.nimbus.State;
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

    private final String englishTable = "englishNoun";
    private final String welshTable = "welshNoun";
    private final String translationTable = "translation";


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

    private void insertEnglish(String noun) throws SQLException {
        Statement st = conn.createStatement();

        try
        {
            st.executeUpdate("INSERT INTO " + englishTable + " VALUES ('" + noun + "');");
        }
        finally
        {
            st.close();
        }
    }

    private void insertWelsh(String noun) throws SQLException
    {
        Statement st = conn.createStatement();
        try
        {
            st.executeUpdate("INSERT INTO " + welshTable + " VALUES ('" + noun + "');");
        }
        finally
        {
            st.close();
        }
    }

    private void addTranslation(String english, String welsh) throws SQLException {
        Statement st = conn.createStatement();

        st.executeUpdate("INSERT INTO " + translationTable + " VALUES ('" + english + "', '" + welsh + "');");
    }
}
