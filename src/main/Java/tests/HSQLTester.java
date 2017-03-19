/*
	Program Title:  HSQLTester
	Author:         Robin McKenna
	Created:        18/03/2017
	Version:        1.0
*/

package tests;

import database.AddUser;
import database.InsertGrade;
import database.UserValidation;

import java.sql.*;
import java.io.*;
import java.sql.ResultSet;

public class HSQLTester
{
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, InterruptedException
	{
		AddUser sysAdmin = new AddUser();
		sysAdmin.addSysAdmin();

		/*
		AddUser student1 = new AddUser();
		student1.addStudent("student1","111");

		AddUser student2 = new AddUser();
		student2.addStudent("student2","222");

		AddUser student3 = new AddUser();
		student3.addStudent("student3","333");

		AddUser student4 = new AddUser();
		student4.addStudent("student4","444");

		AddUser student5 = new AddUser();
		student5.addStudent("student5","555");
		*/

		/*

		// Test - add sysadmin
		AddUser sysAdmin = new AddUser();
		sysAdmin.addSysAdmin();
		
		// Test - validate password
		UserValidation uV = new UserValidation();
		
		String dbHash = uV.getDBHash("sysadmin", "robin");
		String userHash = uV.userHash("abc", "sysadmin", "robin");
		
		System.out.println(dbHash);
		System.out.println(userHash);
		
		if (dbHash.equals(userHash))
		{
			System.out.println("EQUAL");
		}
		else
		{
			System.out.println("NOT EQUAL");
		}
		
		// Test - add student
		AddUser newStudent = new AddUser();
		
		newStudent.addStudent("Ryan", "111");
		
		// Test - InsertGrade
		InsertGrade grade1 = new InsertGrade(20, "Ryan");
		grade1.insertGrade();
		
		Thread.sleep(2000);
		
		// Test - InsertGrade (Same student)
		InsertGrade grade2 = new InsertGrade(15, "Ryan");
		grade2.insertGrade();
		
		*/
	}
}
