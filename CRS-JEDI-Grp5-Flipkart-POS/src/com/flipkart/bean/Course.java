package com.flipkart.bean;

import java.util.ArrayList;

public class Course {
    private String courseID;
    private String courseName;
<<<<<<< HEAD
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
=======
    private String instrutorID;
    private int maxSeats = 10;
    private int minSeats = 3;
    private int numSeats;

    public Course (String courseName, String courseID, String instructorId, int numSeats) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.instrutorID = instructorId;
        this.numSeats = numSeats;
    }
    public Course() {}

    public void setCourseID(String courseID){
        this.courseID = courseID;
    }

    public String getCourseID(){
        return courseID;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public String getCourseName(){
        return courseName;
    }

    public void setInstrutorID(String instrutorID){
        this.instrutorID = instrutorID;
    }

    public String getInstrutorID(){
        return instrutorID;
    }

    public void setNumSeats(int numSeats){
        this.numSeats = numSeats;
    }

    public int getNumSeats(){
        return numSeats;
>>>>>>> dfa90a1b0b748b9c74bbe61ae7b76d62f5c34b35
    }

}
