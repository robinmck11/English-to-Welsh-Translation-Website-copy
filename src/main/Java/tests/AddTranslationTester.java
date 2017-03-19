package tests;

import database.AddTranslation;

import java.sql.SQLException;

/**
 * Created by robin on 19/03/2017.
 */
public class AddTranslationTester
{
    public static void main(String[] args)
    {
        try {
            AddTranslation newTranslation = new AddTranslation("bus", "bws");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
