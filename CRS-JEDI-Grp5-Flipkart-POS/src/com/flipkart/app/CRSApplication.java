package com.flipkart.app;
import com.flipkart.bean.*;
import com.flipkart.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class CRSApplication {

	static boolean loggedin = false;
	public static List<Course> courseList = new ArrayList<>();

	public static Map<String, Course> coursesMap = new HashMap<>();

	public static void main(String[] args) {

		//create the main menu
		Scanner sc = new Scanner(System.in);
		CRSApplication crsApplication=new CRSApplication();
		int userInput;
		//create the main menu
		createLoginPage();
		userInput=sc.nextInt();


		Course c1 = new Course();
		c1.setCourseID("1");
		c1.setCourseName("DBMS");
		c1.setInstructorId("3");

		ArrayList<Student> students1 = new ArrayList<Student>();
		Student stu1 = new Student();
		stu1.setStudentID("1");
		stu1.setStudentName("Rohan");
		students1.add(stu1);
		c1.setEnrolledStudents(students1);

		Course c2 = new Course();
		c2.setCourseID("2");
		c2.setCourseName("OS");
		c2.setInstructorId("3");

		ArrayList<Student> students2 = new ArrayList<Student>();
		Student stu2 = new Student();
		stu2.setStudentID("2");
		stu2.setStudentName("Shubham");
		students2.add(stu2);
		c2.setEnrolledStudents(students2);

		coursesMap.put("1", c1);
		coursesMap.put("2", c2);

		while(userInput!=4)
		{
			switch(userInput)
			{
				case 1:
					//login
					crsApplication.loginUser();
					break;
				case 2:
					//student registration
					crsApplication.registerStudent();
					break;
				case 3:
					crsApplication.updatePassword();
					break;
				default:
					System.out.println("Invalid Input");
			}
			createLoginPage();
			userInput=sc.nextInt();
		}
	}

	/**
	 * Method to Create Main Menu
	 */
	public static void createLoginPage()
	{
		System.out.println("\n\n----------Course Registration System---------\n\n");
		System.out.println("1. Login");
		System.out.println("2. Student Registration");
		System.out.println("3. Update password");
		System.out.println("4. Exit");
		System.out.println("Enter user input");
	}


	public void loginUser()
	{
		System.out.println("\n\n----------User Log In---------\n\n");
		Scanner in = new Scanner(System.in);

		String userId,password;
		int role;

		System.out.println("Email:");
		userId = in.next();
		System.out.println("Password:");
		password = in.next();
		System.out.println("Role:");
		System.out.println("1.Admin");
		System.out.println("2.Professor");
		System.out.println("3.Student");
		role = in.nextInt();
		loggedin = true;

		if (loggedin) {
			switch (role) {
				case 1:
					System.out.println("\n\n----------Log In Successful---------\n\n");
					AdminCRSMenu adminMenu = new AdminCRSMenu();
					adminMenu.createMenu();
					break;
				case 2:
					System.out.println("\n\n----------Log In Successful---------\n\n");
					ProfessorCRSMenu professorMenu=new ProfessorCRSMenu();
					professorMenu.createMenu();

					break;
				case 3:
					System.out.println("\n\n----------Log In Successful---------\n\n");
					StudentCRSMenu studentMenu=new StudentCRSMenu();
					studentMenu.createMenu();
					break;
				default:
					System.out.println("***** Wrong Choice *****");
			}
		}


	}

	public void registerStudent()
	{
		System.out.println("\n\n----------Student Registration---------\n\n");
	}

	public void updatePassword() {
		System.out.println("\n\n----------Update Password---------\n\n");
	}
	
}
