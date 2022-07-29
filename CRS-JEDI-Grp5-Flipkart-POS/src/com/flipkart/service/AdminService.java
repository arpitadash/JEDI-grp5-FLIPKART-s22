package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.*;

public interface AdminService {
    public List<RegisteredCourse> generateGradeCard();

    public void approveStudent();

    public void addProf();

    public boolean removeCourse(String CourseID);

    public void addCourse(Course course);

    public void displayCourses();
}
