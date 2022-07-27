package com.flipkart.service;
import com.flipkart.bean.*;
import java.util.*;

public class RegistrationService {
	
	User u = new User();
	StudentService ss;
	ProfessorService ps;
	AdminService as;
	
	String userType;
	
	
	public User getU() {
		return u;
	}


	public void setU(User u) {
		this.u = u;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	public void login() {
		
		u.getUserDetails();
		
		if (u.checkLoginDetails()==true) {
			
			System.out.println("Welcome to portal!");
			
			System.out.println("Enter User Type");
			Scanner s = new Scanner(System.in);
			
			userType = s.next();
			
			switch (userType) {
				
				case "Student" :
					//display student service
					break;
					
				case "Professor" :
					//display professor service
					break;
					
				case "Admin":
					//display admin service
					break;
			}
				
		}
		
		
	}
	
	
	
	
}
