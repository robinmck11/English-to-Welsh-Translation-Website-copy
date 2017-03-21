package tests;

import database.AddNouns;

import java.sql.SQLException;

/**
 * Created by robin on 19/03/2017.
 */

public class AddTranslationTester
{
    public static void main(String[] args)
    {
        try {
            new AddNouns("bus", "bws");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
