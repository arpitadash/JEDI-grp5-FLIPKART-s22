package com.flipkart.app;
import com.flipkart.bean.*;
import com.flipkart.service.*;

public class CRSApplication {
	
	RegistrationService rs = new RegistrationService();
	
	public void main(String[]args) {
		rs.login();
	}
	
}
