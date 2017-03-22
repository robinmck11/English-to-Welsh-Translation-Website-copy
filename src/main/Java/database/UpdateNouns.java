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

    public void updateNouns(String oldEng, String oldWel, String newEng, String newWel)
    {
        try {

            Statement st = conn.createStatement();

            st.executeUpdate("UPDATE " + tableName + " SET " + englishField + " = " + "'" + newEng + "'" + " WHERE " + englishField + " = " + "'" + oldEng + "';");
            st.executeUpdate("UPDATE " + tableName + " SET " + welshField + " = " + "'" + newWel + "'" + " WHERE " + welshField + " = " + "'" + newWel + "';");

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
