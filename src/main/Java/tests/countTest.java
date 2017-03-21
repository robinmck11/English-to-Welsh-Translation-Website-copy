package tests;

import database.DBCounts;

import java.sql.SQLException;

/**
 * Created by robin on 19/03/2017.
 */

public class countTest
{
    public static void main(String[] args) throws SQLException {
        DBCounts dbCounts = new DBCounts();

        System.out.println("The number of students >: " + dbCounts.getCount("student", "username"));

        System.out.println("The number of Admins >: " + dbCounts.getCount("sysadmin", "username"));

        // Table that has no records

        System.out.println("The number of English Nouns is >: " + dbCounts.getCount("englishnoun", "englishNoun"));
    }
}
