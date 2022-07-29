package com.flipkart.bean;

import java.util.ArrayList;

public class Course {
    private String courseID;
    private String courseName;
    //	private String instructorId;
    private int seats = 10;
    private String instructorId;

    private ArrayList<Student> enrolledStudents;

    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(ArrayList<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    /**
     * @return the courseID
     */
    public String getCourseID() {
        return courseID;
    }
    /**
     * @param courseID the courseID to set
     */
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }
    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    /**
     * @return the instructorId
     */
	public String getInstructorId() {
		return instructorId;
	}
	/**
	 * @param instructorId the instructorId to set
	 */
	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}
    /**
     * @return the seats
     */
    public int getSeats() {
        return seats;
    }
    /**
     * @param seats the seats to set
     */
    public void setSeats(int seats) {
        this.seats = seats;
    }

}
