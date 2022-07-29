package com.flipkart.app;

import com.flipkart.bean.Catalog;
import com.flipkart.bean.Course;

import com.flipkart.bean.Student;
import com.flipkart.service.ProfessorServiceImpl;

import java.util.*;

public class ProfessorCRSMenu {
    public void createMenu(){
        Scanner profIn = new Scanner(System.in);

        while(CRSApplication.loggedin) {
            System.out.println("--------------------------------");
            System.out.println("----------Professor Menu--------");
            System.out.println("--------------------------------");
            System.out.println("1. View Courses");
            System.out.println("2. View Enrolled Students");
            System.out.println("3. Add Grade");
            System.out.println("4. Logout");
            System.out.println("--------------------------------");

            int choice = profIn.nextInt();


            switch(choice) {
                case 1:
                    System.out.println("Enter Professor Id");
                    String profId = profIn.next();

                    ProfessorServiceImpl profObj = new ProfessorServiceImpl();
                    System.out.println(profId);

                    List<Course> profCourses = profObj.viewCourses(profId);
                    System.out.println("Courses: \n");
                    for(Course c : profCourses){
                        System.out.println(c.getCourseName() + " ");
                    }
                    break;

                case 2:
                    System.out.println("View Enrolled Students");

                    System.out.println("Enter Professor Id");
                    String pId = profIn.next();

                    ProfessorServiceImpl pObj = new ProfessorServiceImpl();
                    System.out.println(pId);

                    List<Course> pCourses = pObj.viewCourses(pId);
                    System.out.println("Courses: \n");
                    for(Course c : pCourses){
                        System.out.println("Course " + c.getCourseName() + "\n");
                        ArrayList<Student> students = c.getEnrolledStudents();
                        System.out.println("Students: \n");
                        for(Student stu : students){
                            System.out.println(stu.getStudentName() + " ");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Add Grade");
                    break;

                case 4:
                    CRSApplication.loggedin = false;
                    return;

                default:
                    System.out.println("Wrong Choice, choose again please");
                    break;
            }
        }
    }
}
