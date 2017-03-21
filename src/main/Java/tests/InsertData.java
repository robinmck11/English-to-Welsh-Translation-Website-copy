package tests;

import database.AddUser;
import database.InsertGrade;

import java.sql.SQLException;

/**
 * Created by robin on 19/03/2017.
 */
public class InsertData
{
    public static void main(String[] args) throws SQLException {

        // Drop Tables
        DropTables dropTables = new DropTables();
        System.out.println("Tables have been dropped");

        // Create Tables
        CreateTables createTables = new CreateTables();
        System.out.println("Tables Created");

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

        System.out.println("-USERNAMES AND PASSWORDS -\nstudent1: student1\nstudent2: student2\ninstructor1: instructor1\ninstructor2: instructor2");

        InsertGrade student1Grade1 = new InsertGrade(20, "student1");
    }
}
