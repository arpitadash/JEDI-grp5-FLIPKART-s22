package com.flipkart.service;
import com.flipkart.bean.*;
import com.flipkart.app.*;
import java.util.*;

public class StudentServiceImpl implements StudentService {

	String courseId;
	Scanner studentIn = new Scanner(System.in);
	
	@Override
	public String register() {
		
		System.out.println("Enter course that you want to register");
		
		ArrayList<String> OptedCourses = new ArrayList<String>();
        
    	System.out.println("Enter first primary course: ");
    	String course = studentIn.next();
    	OptedCourses.add(course);
    	System.out.println("Enter second primary course: ");
    	course = studentIn.next();
    	OptedCourses.add(course);
    	System.out.println("Enter third primary course: ");
    	course = studentIn.next();
    	OptedCourses.add(course);
    	System.out.println("Enter fourth primary course: ");
    	course = studentIn.next();
    	OptedCourses.add(course);
    	
		Scanner s = new Scanner(System.in);
		
		int registered = 0;
		int notregistered = 0;
		
		for(String crs: OptedCourses) {
			
			Course c = CRSApplication.courseList.get(crs);
			
			if (c.getRegisteredStudents() == 10) {
				System.out.println("Course" + crs + "is full");
				notregistered++;
				
			}
			
			else {
				c.setRegisteredStudents(c.getRegisteredStudents()+1);
				CRSApplication.courseList.put(c.getCourseID(), c);
				registered++;
			}
			
		}
		
		while(notregistered-->0) {
			System.out.println("Enter secondary course: ");
	    	course = studentIn.next();
	    	Course c = CRSApplication.courseList.get(course);
	    	c.setRegisteredStudents(c.getRegisteredStudents()+1);
			CRSApplication.courseList.put(c.getCourseID(), c);
			
		}

		
		return null;
	}

	public void replaceCourse() {
		System.out.println("Enter course Id you want to replace");
		String course = studentIn.next();
		
		Course c = CRSApplication.courseList.get(course);
		if (c.getRegisteredStudents() == 10) {
			System.out.println("This course can not be replaced");
			
		}
		
		else {
			Course c1 = new Course();
			c1.setCourseID(c.getCourseID());
			c1.setCourseName(c.getCourseName());
			c1.setInstructorId(c.getInstructorId());
			c1.setRegisteredStudents(c.getRegisteredStudents()-1);
			CRSApplication.courseList.put(c.getCourseID(),c1);
			
			System.out.println("Enter course Id you want to add");
			course = studentIn.next();
			
			Course c3 = CRSApplication.courseList.get(course);
			
			Course c2 = new Course();
			c2.setCourseID(c3.getCourseID());
			c2.setCourseName(c3.getCourseName());
			c2.setInstructorId(c3.getInstructorId());
			c2.setRegisteredStudents(c3.getRegisteredStudents()+1);
			CRSApplication.courseList.put(c3.getCourseID(),c2);
		}
	}
	
	@Override
	public String viewGrades() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
