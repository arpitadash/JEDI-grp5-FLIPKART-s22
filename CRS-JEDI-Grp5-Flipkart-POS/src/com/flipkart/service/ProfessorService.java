package com.flipkart.service;
import com.flipkart.bean.*;

import java.util.List;

public interface ProfessorService {
    public boolean addGrade();

    public List<Course> viewCourses(String profId);


    public List<Student> viewEnrolledStudents(String profId);
}
