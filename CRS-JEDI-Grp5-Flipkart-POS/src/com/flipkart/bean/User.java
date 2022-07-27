package com.flipkart.bean;
import java.util.*;

public class User {
	
	String username;
	String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean checkLoginDetails() {
			
		if (username.equals("nikita") && password.equals("hey")) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public void getUserDetails() {
		System.out.println("Enter username");
		Scanner s = new Scanner(System.in);
		username = s.nextLine();
		
		
		System.out.println("Enter password");
		password = s.nextLine();
		
		
	}
}
