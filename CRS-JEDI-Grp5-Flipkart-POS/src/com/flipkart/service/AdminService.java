package com.flipkart.service;

import java.util.*;
import com.flipkart.bean.*;

public class AdminService{
    private static volatile AdminService instance = null;
    private Context.ThrowErrorManager logger;

    public static AdminService getInstance()
    {
        if(instance == null)
        {
            synchronized (AdminService.class){
                instance = new AdminService();
            }
        }
        return instance;
    }

    public Course addCourse(String course_name, String courseID, String courseInstructor, int numSeats){
        try {
            Course newCourse = new Course();
            newCourse.setCourseName(course_name);
            newCourse.setCourseID(courseID);
            newCourse.setInstrutorID(courseInstructor);
            newCourse.setNumSeats(numSeats);

            System.out.println("Course Added Succesfully"); // Need to replace this with SQL query
            return newCourse;
        }
        catch(CourseAlreadyPresentException e) { // need to add all the exception in the exception folder.
            CourseAlreadyPresentException er = new CourseAlreadyPresentException(courseID);
            logger.error(er.getMessage());
            return null;
        }
    }

    public void removeCourse(String courseID){
        try {
            System.out.println("Course Removed Succesfully"); //Need to replace this with the SQL query.
        }
        catch (CourseNotFoundException e){
            CourseNotFoundException ex = new CourseNotFoundException(courseID);
            logger.error(ex.getMessage());

        }
        return;
    }
    public Professor addProfessor(String email, String name, String password, String department, String designation, String joiningDate,String address,String contact){
        try {
            Professor newProf = new Professor();
            newProf.setEmail(email);
            newProf.setProfessorId(email);
            newProf.setName(name);
            newProf.setPassword(password);
            newProf.setDepartment(department);
            newProf.setDesignation(designation);
            newProf.setJoinDate(joinDate);
            newProf.setAddress(address);
            newProf.setContactNum(contact);
            System.out.println("New Professor Added");  // need to replace this with the SQL query.
            return newProf;
        }
        catch(UsernameTakenException e){
            logger.error(e.getMessage());
            return null;
        }
    }
    public void removeProfessor(System professorID){
        try {
            System.out.println("Professor Removed Successfully"); // need to replace this with SQL query.
        }
        catch (UserNotFoundException ex){
            logger.error(ex.getMessage());
        }
    }
}