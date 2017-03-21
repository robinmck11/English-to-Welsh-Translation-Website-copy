package database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by robin on 21/03/2017.
 */
public class RemoveRecord
{

    private InputStream inputStream;
    private Connection conn;

    public RemoveRecord()
    {
        inputStream = AddUser.class.getResourceAsStream("/database.properties");

        try
        {
            SimpleDataSource.init(inputStream);
            conn = SimpleDataSource.getConnection();

        } catch (IOException | ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void removeRecord(String tableName, String field, String value){
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM " + tableName + " WHERE " + field + " = '" + value + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
