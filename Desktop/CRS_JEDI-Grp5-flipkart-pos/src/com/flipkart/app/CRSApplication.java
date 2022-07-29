/**
 * 
 */
package com.flipkart.app;
import java.util.*;

//import com.flipkart.app.AdminCRSMenu;
//import com.flipkart.app.ProfessorCRSMenu;
import com.flipkart.app.StudentCRSMenu;
import com.flipkart.bean.Course;
import com.flipkart.service.AdminService;

public class CRSApplication {
	
	static boolean loggedin = false;
	public static HashMap<String,Course> courseList = new HashMap<String,Course>();
	public static void main(String[] args) {
	
		//create the main menu
		Scanner sc = new Scanner(System.in);
		CRSApplication crsApplication=new CRSApplication();
		int userInput;	
		//create the main menu
		createMainMenu();
		userInput=sc.nextInt();
		
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
			createMainMenu();
			userInput=sc.nextInt();
		}
	}
	
	/**
	 * Method to Create Main Menu
	 */
	public static void createMainMenu()
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
		System.out.println("\n\nEnter login details\n\n");
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
				AdminService as = new AdminService();
            	as.AddCourse();
//				adminMenu.createMenu();
				break;
			case 2:
//				System.out.println("\n\n----------Log In Successful---------\n\n");
//				ProfessorCRSMenu professorMenu=new ProfessorCRSMenu();
//				professorMenu.createMenu();
				
				break;
			case 3:
				System.out.println("\n\nLogged in\n\n");
				StudentCRSMenu studentMenu=new StudentCRSMenu();
				studentMenu.createMenu();
				break;
			default:
				System.out.println("Wrong Choice");
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