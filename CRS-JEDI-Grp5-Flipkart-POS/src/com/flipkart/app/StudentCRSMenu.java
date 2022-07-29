package com.flipkart.app;
import com.flipkart.bean.*;
import java.util.Scanner;

import com.flipkart.service.AdminService;
import com.flipkart.service.StudentServiceImpl;
import java.util.*;
public class StudentCRSMenu {

    Scanner studentIn = new Scanner(System.in);
    StudentServiceImpl s = new StudentServiceImpl();
    
    public void createMenu(){

        while(CRSApplication.loggedin) {
            
            System.out.println("Student Menu");
            System.out.println("1. Course Registration");
            System.out.println("2. Replace Course");
            System.out.println("3. View Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. View grade card");
            System.out.println("6. Make Payment");
            System.out.println("7. Logout");
            System.out.println();

            int choice = studentIn.nextInt();

            switch(choice) {
                case 1:
                	
                    s.register();
                    System.out.println("Course registration done");
                    break;

                case 2:
                	s.replaceCourse();
                    System.out.println("Replaced course");
                    
                    break;

                case 3:
                    System.out.println("remove course");
                    break;

                case 4:
                    System.out.println("view course");
                    break;

                case 5:
                    System.out.println("view registered courses");
                    break;

                case 6:
                    System.out.println("view grade card");
                    break;

                case 7:
                    System.out.println("make payment");
                    break;
                case 8:
                	CRSApplication.loggedin = false;
    				return;

                default:
                    System.out.println("Incorrect Choice!");
            }
        }
    }

}
