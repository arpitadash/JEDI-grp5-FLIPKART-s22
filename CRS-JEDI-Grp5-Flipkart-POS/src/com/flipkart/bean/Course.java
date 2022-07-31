package com.flipkart.bean;

import java.util.ArrayList;

public class Course {
    private String courseID;
    private String courseName;
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
    }

}
