package com.flipkart.service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.flipkart.exception.*;
import com.flipkart.dao.SemesterRegistrationDaoInterface;
import com.flipkart.dao.SemesterRegistrationDaoImplementation;
import com.flipkart.dao.StudentDaoImplementation;
import com.flipkart.dao.StudentDaoInterface;


import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import jdk.nashorn.internal.runtime.Context;


public class SemesterRegistrationImplementation implements SemesterRegistrationInterface {
    ArrayList<String> Mycourses1 = new ArrayList<String>();
    ArrayList<String> Mycourses2 = new ArrayList<String>();
    SemesterRegistrationDaoImplementation srdo = new SemesterRegistrationDaoImplementation();
    StudentDaoImplementation SDO = new StudentDaoImplementation();
    private Context.ThrowErrorManager logger;

    // function to register course
    /**
     * Method to register course by student
     * @param studentId
     * @return  boolean
     * @return  boolean
     */
    public boolean registerCourses(String studentId)
    {
        try {

            Boolean val = srdo.registerCourses(studentId);
            NotificationInterface notificationObj = new NotificationImplementation();
            notificationObj.sendPayFeesNotification();
            return val;

       } catch (InvalidSemesterRegistration e) {
            logger.error(e.getMessage());
        } catch (PaymentDoneException e) {
            logger.error(e.getMessage());
        }
        return false;
    }
    // function to add course
    /**
     * Method to add Course
     * @param studentId
     * @param CourseId
     * @param isPrimary
     * @return  boolean
     */
    public boolean addCourse(String studentId, String CourseId, boolean isPrimary)
    {
        //added in dataBase
        try {

            return srdo.addCourse(studentId, CourseId, isPrimary);

        } catch (CourseNotFoundException | CourseSeatsUnavailableException | CourseExistsInCartException e ) {
            //System.out.println("Exception in adding course");
           // logger.error(e.getMessage());
        }
        return false;
    }
    // function to drop course
    /**
     * Method to drop course
     * @param studentId
     * @param SemesterId
     * @param CourseId
     * @return  boolean
     */
    public boolean dropCourse(String studentId, int SemesterId, String CourseId)
    {
        try {

            return srdo.dropCourse(studentId, SemesterId, CourseId);

        } catch (CourseNotFoundException | CourseNotInCart e) {
            System.out.println("Course Not Found");
            //logger.error(e.getMessage());
        }
        return false;

    }
    //function to view course catalog
    /**
     * Method to view course catalog
     * @return  list of course
     */
    public ArrayList<Course> viewCourseCatalog()
    {

        try {

        ArrayList<Course> courseCatalog = srdo.viewAvailableCourses();
        if(courseCatalog == null) {
            //System.out.println("Error encountered while retrieving course catalog");
            throw new Exception("Error encountered while retrieving course catalog");
        }
        return srdo.viewAvailableCourses();

    } catch (Exception e) {
            System.out.println("Some exception generated while viewing course catalog");
        logger.error(e.getMessage());
    }
        return null;
    }
    // function to view Registered course
    /**
     * Method to view Registered courses
     * @param studentId
     * @return  void
     */
    public List<Course> viewRegisteredCourses(String studentId) throws StudentNotRegisteredException
    {

        List<Course> courses= SDO.viewRegisteredCourses(studentId);
        if(courses.isEmpty())
        {
            System.out.println("You have not registered for any courses");
            return null;
        }
        return courses;
    }
    // function to check payment window

    public Boolean checkPaymentWindow(String StudentID)   {
            return SDO.checkPaymentWindow(StudentID);

    }
}
