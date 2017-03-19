package tests;

import database.UserValidation;

/**
 * Created by robin on 19/03/2017.
 */
public class StudentValidationTester
{
    public static void main(String[] args)
    {
        UserValidation uv = new UserValidation();

        String dbHash = uv.getDBHash("student", "Ryan");
        String userHash = uv.userHash("111", "student", "Ryan");

        System.out.println(dbHash);
        System.out.println(userHash);

        if (dbHash.equals(userHash))
        {
            System.out.println("true");
        }
        else
            System.out.println("false");
    }
}
