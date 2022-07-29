package com.flipkart.service;
import com.flipkart.bean.*;
import com.flipkart.app.*;

public class AdminService {
	
	public void AddCourse() {
		
		Course temp1 = new Course();
		temp1.setCourseID("English");
		temp1.setCourseName("English");
		temp1.setInstructorId("123");
		temp1.setRegisteredStudents(0);
		CRSApplication.courseList.put("English", temp1);
		
		Course temp2 = new Course();
		temp1.setCourseID("Hindi");
		temp1.setCourseName("English");
		temp1.setInstructorId("123");
		temp1.setRegisteredStudents(0);
		CRSApplication.courseList.put("Hindi", temp2);
		
		Course temp3 = new Course();
		temp1.setCourseID("Science");
		temp1.setCourseName("English");
		temp1.setInstructorId("123");
		temp1.setRegisteredStudents(0);
		CRSApplication.courseList.put("Science", temp3);
		
		Course temp4 = new Course();
		temp1.setCourseID("Maths");
		temp1.setCourseName("English");
		temp1.setInstructorId("123");
		temp1.setRegisteredStudents(0);
		CRSApplication.courseList.put("Maths", temp4);
		
		Course temp5 = new Course();
		temp1.setCourseID("Sanskrit");
		temp1.setCourseName("English");
		temp1.setInstructorId("123");
		temp1.setRegisteredStudents(0);
		CRSApplication.courseList.put("Sanskrit", temp5);
		
		Course temp6 = new Course();
		temp1.setCourseID("Melon");
		temp1.setCourseName("English");
		temp1.setInstructorId("123");
		temp1.setRegisteredStudents(0);
		CRSApplication.courseList.put("Melon", temp6);
		
		
	}
}
