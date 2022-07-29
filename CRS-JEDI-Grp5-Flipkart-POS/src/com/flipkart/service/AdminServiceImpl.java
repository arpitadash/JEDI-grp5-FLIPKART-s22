package com.flipkart.service;

import com.flipkart.app.CRSApplication;
import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourse;

import java.util.List;

public class AdminServiceImpl implements AdminService{

    @Override
    public List<RegisteredCourse> generateGradeCard() {
        return null;
    }

    @Override
    public void approveStudent() {

    }

    @Override
    public void addProf() {

    }

    @Override
    public boolean removeCourse(String CourseID) {
        return false;
    }

    @Override
    public void addCourse(Course course) {
        CRSApplication.courseList.add(course);
    }

    @Override
    public void displayCourses() {

    }
}
