package com.flipkart.bean;

public class Course {
    private String courseID;
    private String courseName;
    //	private String instructorId;
    private int maxseats = 10;
    private int minseats = 3;
    public String getCourseID() {
        return courseID;
    }
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

//	public String getInstructorId() {
//		return instructorId;
//	}
//	/**
//	 * @param instructorId the instructorId to set
//	 */
//	public void setInstructorId(String instructorId) {
//		this.instructorId = instructorId;
//	}
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
