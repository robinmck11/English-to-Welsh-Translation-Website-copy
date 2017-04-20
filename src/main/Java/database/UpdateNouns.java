package database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by robin on 21/03/2017.
 */
public class UpdateNouns
{
    private InputStream inputStream;
    private Connection conn;

    private final String tableName = "nouns";

    private final String welshField = "welshNoun";
    private final String englishField = "englishNoun";
    private final String genderField = "gender";

    public UpdateNouns()
    {
        inputStream = UpdateNouns.class.getResourceAsStream("/database.properties");

        try
        {
            SimpleDataSource.init(inputStream);
            conn = SimpleDataSource.getConnection();

        } catch (IOException | ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Update a noun in the nouns table
     * @param oldEng the old english word to update
     * @param oldWel the old welsh word to update
     * @param newEng the new english word
     * @param newWel the new welsh word
     */

    public void updateNouns(String oldEng, String oldWel, String newEng, String newWel, String oldGender, String newGender)
    {
        try {

            // Might aswell leave this as statement

            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE " + tableName + " SET " + englishField + " = " + "'" + newEng + "'" + " WHERE " + englishField + " = " + "'" + oldEng + "';");
            st.executeUpdate("UPDATE " + tableName + " SET " + welshField + " = " + "'" + newWel + "'" + " WHERE " + welshField + " = " + "'" + newWel + "';");
            st.executeUpdate("UPDATE " + tableName + " SET " + genderField + " = " + "'" + newGender + "'" + " WHERE " + genderField + " = " + "'" + newGender + "';");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
