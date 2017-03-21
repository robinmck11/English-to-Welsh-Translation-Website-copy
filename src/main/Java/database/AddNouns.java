package database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by robin on 19/03/2017.
 */
public class AddNouns
{
    private String englishNoun;
    private String welshNoun;

    private final String translationTable = "translation";


    private InputStream inputStream;
    private Connection conn;

    public AddNouns(String englishNoun, String welshNoun) throws SQLException
    {
        this.englishNoun = englishNoun;
        this.welshNoun = welshNoun;

        inputStream = AddNouns.class.getResourceAsStream("/database.properties");

        try
        {
            SimpleDataSource.init(inputStream);
            conn = SimpleDataSource.getConnection();

            addTranslation(englishNoun, welshNoun);

        } catch (IOException | ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            conn.close();
        }
    }

    private void addTranslation(String english, String welsh) throws SQLException {
        Statement st = conn.createStatement();

        st.executeUpdate("INSERT INTO " + translationTable + " VALUES ('" + english + "', '" + welsh + "');");
    }
}
