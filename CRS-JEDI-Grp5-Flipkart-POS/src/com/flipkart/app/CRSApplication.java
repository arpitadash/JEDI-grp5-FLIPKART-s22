package com.flipkart.app;
import com.flipkart.bean.*;
import com.flipkart.service.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

import com.flipkart.app.AdminCRSMenu;
public class CRSApplication {
	static boolean loggedin = false;
	Course course = new Course();
	Map<Integer, course> map = new HashMap<String, course>();
	
	public void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		CRSApplication crsApplication=new CRSApplication();

		createLoginPage();
		int usercase;
		usercase= scanner.nextInt();
		while(true)
		{
			if(usercase == 1){
				crsApplication.loginUser();
			}
			else if(usercase ==2){
				crsApplication.studentRegistration();
			}
			else if(usercase == 3){
				crsApplication.updatePassword();
			}
			else{
				break;
			}
		}
	}

	public static void createLoginPage()
	{
		System.out.println("\n\n----------Course Registration System---------\n\n");
		System.out.println("1. Login");
		System.out.println("2. Student Registration");
		System.out.println("3. Update password");
		System.out.println("4. Exit");
		System.out.println("Enter user input");
	}

	public void loginUser(){
		System.out.println("\n\n----------User Log In---------\n\n");
		Scanner userlogin = new Scanner(System.in);

		String userId,password;
		int role;

		System.out.println("Email:");
		userEmail = userlogin.next();
		System.out.println("Password:");
		password = userlogin.next();
		System.out.println("Role:");
		System.out.println("1.Admin		2.Professor		3.Student");
		role = userlogin.nextInt();

		while(role!=1 || role!=2 || role!=3)
		{
			system.out.println("***** Invalid Role please select correct role *****");
			role = userlogin.nextInt();
		}

		if(verifyUser(userEmail,password,role)){
			loggedin = true;
		}
		else {
			System.out.println("Invalid User");
			loginUser();
		}

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
			}
		}
	}
    public static boolean verifyuser(String email, String pass, int role) throws IOException {
        File f = new File("../../../../resources/Sheet1.csv");
        FileReader fr = null;
        try {
            fr = new FileReader(f);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(fr);
        String line = " ";
        String[] tempA;
        while((line = br.readLine()) != null)
        {
            tempA = line.split(",");
            System.out.println(tempA[0]+email);
            System.out.println(tempA[1]+pass);
            System.out.println(tempA[2]+role);
            if(tempA[0].equals(email) && tempA[1].equals(pass) && Integer.parseInt(tempA[2]) == role) {
                return true;
            }
        }
        br.close();
        return false;
    }
}
