package tests;

import database.AddNouns;
import database.AddUser;
import database.InsertGrade;

import java.sql.SQLException;

/**
 * Created by robin on 19/03/2017.
 */
public class InsertData
{
	public static void main(String[] args) throws SQLException
	{
		
		// Drop Tables
		DropTables dropTables = new DropTables();
		System.out.println("Tables have been dropped");
		
		// Create Tables
		CreateTables createTables = new CreateTables();
		System.out.println("Tables Created");
		
		AddUser admin = new AddUser();
		
		try
		{
			admin.addSysAdmin();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		AddUser student1 = new AddUser();
		AddUser student2 = new AddUser();
		
		try
		{
			student1.addStudent("student1", "student1");
			student2.addStudent("student2", "student2");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		AddUser instructor1 = new AddUser();
		AddUser instructor2 = new AddUser();
		
		try
		{
			instructor1.addInstructor("instructor1", "instructor1");
			instructor2.addInstructor("instructor2", "instructor2");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		
		try
		{
			AddNouns noun = new AddNouns("flag", "baner", "f");
			noun = new AddNouns("kinship", "ach", "f");
			noun = new AddNouns("fruits", "aeron", "f");
			noun = new AddNouns("raspberries", "afan", "f");
			noun = new AddNouns("river", "afon", "f");
			noun = new AddNouns("exit", "allanfa", "f");
			noun = new AddNouns("hillside", "allt", "f");
			noun = new AddNouns("keyboard", "allweddell", "f");
			noun = new AddNouns("cheek", "boch", "f");
			noun = new AddNouns("breeze", "awel", "f");
			noun = new AddNouns("kingdom", "brenhiniaeth", "f");
			
			noun = new AddNouns("bait", "abwyd", "m");
			noun = new AddNouns("cold", "annwyd", "m");
			noun = new AddNouns("plough", "aradr", "m");
			noun = new AddNouns("birds", "adar", "m");
			noun = new AddNouns("rain", "adlaw", "m");
			noun = new AddNouns("wrist", "arddwrn", "m");
			noun = new AddNouns("weapon", "arf", "m");
			noun = new AddNouns("money", "arian", "m");
			noun = new AddNouns("bear", "arth", "m");
			noun = new AddNouns("grave", "bedd", "m");
			noun = new AddNouns("dirt", "baw", "m");
			noun = new AddNouns("tip", "blaen", "m");
			noun = new AddNouns("flour", "blawd", "m");
			noun = new AddNouns("sign", "arwydd", "m");
			noun = new AddNouns("opening", "agoriad", "m");
			noun = new AddNouns("hippopotamus", "afonfarch", "m");
			noun = new AddNouns("liver", "afu", "m");
			noun = new AddNouns("zeal", "aidd", "m");
			noun = new AddNouns("swan", "alarch", "m");
			noun = new AddNouns("comma", "atalnod", "m");
			noun = new AddNouns("flower", "blodyn", "m");
			noun = new AddNouns("yearbook", "blwyddiadur", "m");
			noun = new AddNouns("tummy", "bol", "m");
			noun = new AddNouns("teacher", "athro", "m");
			noun = new AddNouns("stomach", "bola", "m");
			noun = new AddNouns("fat", "braster", "m");
			noun = new AddNouns("treason", "brad", "m");
			noun = new AddNouns("bacon", "bacwn", "m");
			noun = new AddNouns("peak", "ban", "m");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("-USERNAMES AND PASSWORDS -\nstudent1: student1\nstudent2: student2\ninstructor1: instructor1\ninstructor2: instructor2");
		
		InsertGrade student1Grade1 = new InsertGrade(20, "student1");
	}
}
