package tests;

import database.AddUser;
import database.InsertGrade;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by robin on 19/03/2017.
 */
public class InsertData
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println("Drop tables ? (y/n)");

        DropTables dropTables;

        if (input.equals('y'))
        {
            dropTables = new DropTables();
            System.out.println("Tables have been dropped");
        }
        else if (input.equals('n'))
            System.out.println("No Tables Dropped");

        System.out.println("Now adding data to tables");

        AddUser admin = new AddUser();

        try {
            admin.addSysAdmin();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        AddUser student1 = new AddUser();
        AddUser student2 = new AddUser();

        try {
            student1.addStudent("student1", "student1");
            student2.addStudent("student2", "student2");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        AddUser instructor1 = new AddUser();
        AddUser instructor2 = new AddUser();

        try {
            instructor1.addInstructor("instructor1", "instructor1");
            instructor2.addInstructor("instructor2", "instructor2");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        InsertGrade student1Grade1 = new InsertGrade(20, "student1");
    }
}