package com.flipkart.bean;

import java.util.HashMap;
import java.util.Map;

public class Catalog {
    Map courseList = new HashMap<Integer, Course>();

    public Map getCourseList() {
        return courseList;
    }

    public void setCourseList(Map courseList) {
        this.courseList = courseList;
    }
}
