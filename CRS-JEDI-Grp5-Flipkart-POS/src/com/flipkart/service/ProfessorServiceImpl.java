package com.flipkart.service;

import com.flipkart.app.CRSApplication;
import com.flipkart.bean.Catalog;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfessorServiceImpl implements ProfessorService {
    @Override
    public boolean addGrade() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Course> viewCourses(String profId) {
        List<Course> profCourses = new ArrayList<>();

        Map<String, Course> coursesList = CRSApplication.coursesMap;

        if(coursesList!=null){

            for(Course c : coursesList.values()) {
                if (profId.equals(c.getInstructorId())) {
                    profCourses.add(c);
                }
            }
        }

        return profCourses;
    }

    @Override
    public List<Student> viewEnrolledStudents(String profId) {
        List<Course> profCourses = new ArrayList<>();

        Map<String, Course> coursesList = CRSApplication.coursesMap;

        if(coursesList!=null){

            for(Course c : coursesList.values()) {
                if (profId.equals(c.getInstructorId())) {
                    profCourses.add(c);
                }
            }
        }



        return null;
    }
}
