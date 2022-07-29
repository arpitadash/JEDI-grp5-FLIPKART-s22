/**
 * 
 */
package com.flipkart.bean;

public class Course 
{
	private String courseID;
	private String courseName;
	private String instructorId;
	
	private int maxseats = 10;
	private int minseats = 3;
	private int registeredStudents = 0;
	

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}
	
	public void setMaxseats(int maxseats) {
		this.maxseats = maxseats;
	}
	
	public void setMinseats(int minseats) {
		this.minseats = minseats;
	}
	
	public void setRegisteredStudents(int registeredStudents) {
		this.registeredStudents = registeredStudents;
	}
	
	public String getCourseName() {
		return courseName;
	}

	public String getCourseID() {
		return courseID;
	}
	
	public String getInstructorId() {
		return instructorId;
	}

	public int getMaxseats() {
		return maxseats;
	}

	public int getMinseats() {
		return minseats;
	}

	public int getRegisteredStudents() {
		return registeredStudents;
	}	
	
}