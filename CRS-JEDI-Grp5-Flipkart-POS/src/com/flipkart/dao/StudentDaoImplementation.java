package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.constant.SQLQueries;
import com.flipkart.exception.*;
import com.flipkart.utils.DBUtil;
import jdk.nashorn.internal.runtime.Context;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import java.util.*;
//import java.util.Date;
import java.util.Scanner;

public class StudentDaoImplementation implements StudentDaoInterface {

    private Context.ThrowErrorManager logger;

    public static void main(String[]args) {
        StudentDaoImplementation test = new StudentDaoImplementation();
        //test.checkPaymentWindow(5);//need to see check payment window
    }


    private static volatile StudentDaoImplementation instance=null;




    public static StudentDaoImplementation getInstance() {
        if(instance==null)
        {
            // This is a synchronized block, when multiple threads will access this instance
            synchronized(StudentDaoImplementation.class){
                instance = new StudentDaoImplementation();
            }
        }
        return instance;
    }

    public Student addStudent(Student student) throws UsernameTakenException {

        Connection connection = DBUtil.getConnection();

        try
        {
            //PreparedStatement stmt = connection.prepareStatement(SQLQueries.GET_MAX_STUDENT_ID);
            /* ResultSet results = stmt.executeQuery();
            String studentId="200";
            if(results == null)
            {
                studentId="0";
            }
            else if(results.next()) {
                studentId=results.getString(1);
            }
            int nextstudentid=Integer.valueOf(studentId)+1;
            studentId=Integer.toString(nextstudentid);
            student.setUserId(studentId);
            student.setStudentId(studentId);*/

            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.ADD_USER);
            preparedStatement.setString(1, student.getUserId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getPassword());
            preparedStatement.setString(4, student.getJoiningDate());
            preparedStatement.setString(5, "student");
            preparedStatement.setString(6, student.getAddress());
            preparedStatement.setString(7, student.getContactnum());
            preparedStatement.executeUpdate();

            PreparedStatement preparedStatement1 = connection.prepareStatement(SQLQueries.ADD_STUDENT);
            preparedStatement1.setString(1, student.getStudentId());
            preparedStatement1.setString(2, student.getDepartment());
            preparedStatement1.setBoolean(3, false);
            preparedStatement1.setBoolean(4, true);
            preparedStatement1.executeUpdate();

        }
        catch(SQLException ex) {
            System.out.println("Username taken exception");
            throw new UsernameTakenException();

        }
        return student;
    }

    public List<Grade> viewReportCard(String StudentID) throws ReportCardNotGeneratedException, GradeNotAddedException , StudentNotApprovedException, FeesPendingException{

        Connection connection = DBUtil.getConnection();
        List<Grade> R = new ArrayList<Grade>();
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.CHECK_GRADECARD);
            preparedStatement.setString(1,"1");
            ResultSet rc = preparedStatement.executeQuery();

            rc.next();
            if(rc.getBoolean("gradecardgenerationwindow")) {
                PreparedStatement prepareStatement = connection.prepareStatement(SQLQueries.GET_GRADECARD);
                prepareStatement.setString(1, StudentID);

                ResultSet rs = prepareStatement.executeQuery();

                while(rs.next()){
                    Grade g = new Grade();
                    g.setCourseId(rs.getString("coursecode"));
                    g.setGrade(rs.getString("grade"));
                    R.add(g);
                }
            }
            else{
                System.out.println("Report Card not yet generated! Please contact admin for further details.");
                throw new ReportCardNotGeneratedException();
            }

            //System.out.println(rs);

        } catch(SQLException e) {
            logger.error(e.getMessage());
        }
        if(R.isEmpty()) {
            System.out.println("Grade Card not Generated yet!!");
            throw new ReportCardNotGeneratedException();
        }

        return R;
    }

    public List<Course> viewRegisteredCourses(String studentID) throws StudentNotRegisteredException {

        Connection connection=DBUtil.getConnection();
        List<Course> registeredCourses = new ArrayList<Course>();

        try
        {
            PreparedStatement preparedStatement=connection.prepareStatement(SQLQueries.GET_COURSES_STUDENT);
//            System.out.println("Here 2"+preparedStatement);
            preparedStatement.setString(1, studentID);
//            System.out.println("Here 1"+preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
//            System.out.println("here" + rs);

            while (rs.next()) {
                String courseId = rs.getString("coursecode");
//                System.out.println("CourseID: "+courseId);

                PreparedStatement preparedStatement0 = connection.prepareStatement(SQLQueries.GET_COURSE_BY_ID);
                preparedStatement0.setString(1, courseId);
//                System.out.println("ResultSet: "+preparedStatement0);
                ResultSet rs0 = preparedStatement0.executeQuery();
                ResultSetMetaData rsmd0 = rs0.getMetaData();
//                System.out.println(rsmd0.getColumnLabel(1));
//                System.out.println("ResultSet: "+preparedStatement0);

                if(rs0.next()) {
//                    System.out.println("IN");
                    Course c = new Course();
//                    System.out.println("df1"+c);
                    c.setCourseCode(courseId);
//                    System.out.println("df2"+c);
                    c.setCourseName(rs0.getString("coursecode"));
//                    System.out.println("df3"+c);
//                    System.out.println("df4"+rs0.getString("instructorid"));
                    c.setInstructorId(rs0.getString("instructorid"));

                    c.setIsprimary(rs.getBoolean("isprimary"));
//                    System.out.println("df5"+c);
//                    System.out.println(c);
                    registeredCourses.add(c);
//                    System.out.println("df6"+c);
                }
            }
        }

        catch(SQLException e) {
            logger.error(e.getMessage());
        }

        if(registeredCourses.isEmpty()) {
            System.out.println("Student not registered");
            throw new StudentNotRegisteredException();
        }

        return registeredCourses;
    }

    public Boolean checkPaymentWindow(String StudentID)  /*throws PaymentWindowException , StudentNotRegisteredException*/ {

       /*boolean isPaymentOpen = false;
        Connection conn = DBUtil.getConnection();

        try {

            PreparedStatement stmt, stmt2;
            stmt = conn.prepareStatement(SQLQueries.GET_SEM_BY_STUDENT, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            stmt.setString(1, StudentID);
            ResultSet rs = stmt.executeQuery();
            if(!rs.next()){
                System.out.println("Student Not Registered");
                //throw new StudentNotRegisteredException();
            }
            else{

                rs.first();
                int sem_id = rs.getInt(1);

                stmt2 = conn.prepareStatement(SQLQueries.SEM_PAYMENT_WINDOW,ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                stmt2.setString(1, Integer.toString(sem_id));
                ResultSet rs2 = stmt2.executeQuery();
                rs2.first();
                int isOpen = rs2.getInt(1);
                if (isOpen == 1)
                    isPaymentOpen = true;

                if (isPaymentOpen == false) {
                    System.out.println("Payment Window Exception");
                    //throw new PaymentWindowException();
                }

            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return isPaymentOpen;*/
        return true;

    }



}