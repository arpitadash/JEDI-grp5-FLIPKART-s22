package com.flipkart.app;

import java.util.*;

public class AdminCRSMenu{
    private Scanner scanner = new Scanner(System.in);
    AdminCRSMenu adminCRSMenu = new AdminCRSMenu();

    public void createAdminMenu(String adminId){
        System.out.println("*************Admin Menu**************");
        System.out.println("--------------------------------------");
        System.out.println("Kindly select one option from the menu");
        System.out.println("--------------------------------------");
        System.out.println("1. Edit Course Details in the course catalog");
        System.out.println("2. Add/Remove Professor");
        System.out.println("3. Add/Remove Admin");
        System.out.println("4. Enable/Disable Payment window");
        System.out.println("5. View available Courses for seat availability");
        System.out.println("6. Cancel course registration");
        System.out.println("7. View course wise student list");
        System.out.println("8. View Course wise grades");
        System.out.println("9. Generate Grade Card");
        System.out.println("10. Logout");
        int menuChoice = scanner.nextInt();
        scanner.nextLine();
        switch (menuChoice){
            case 1:
                // Edit course details
                editCourseDetails();
                createAdminMenu (adminId);
                break;
            case 2:
                // add remove professor
                addRemoveProfessor();
                createAdminMenu (adminId);
                break;
            case 3:
                // add remove admin
                addRemoveAdmin();
                createAdminMenu (adminId);
                break;
            case 4:
                // enable/disbale payment window
                enabledisableFeePaymentWindow();
                createAdminMenu (adminId);
                break;
            case 5:
                // view available courses
                viewAvailableCourses();
                createAdminMenu (adminId);
                break;
            case 6:
                // approve student registration
//                System.out.println("Not an admin function - it is automated")
//                approveStudentRegistration();
                cancelCourseRegistration();
                createAdminMenu (adminId);
                break;
            case 7:
                // view course wise student list - fetch from db
                viewCourseStudentList();
                createAdminMenu (adminId);
                break;
            case 8:
                // view course wise grades - fetch from db
                viewCourseGrades();
                createAdminMenu (adminId);
                break;
            case 9:
                // generate grade card;
                generateGradeCard();
                createAdminMenu (adminId);
                break;
            case 10:
                break;


    }
}


    /**
     *
     * Function to approve student registration
     */

//    private void approveStudentRegistration() {
//        int semester;
//        String studentID;
//        // fetch Students information
//
//        ArrayList<String> pendingstudents = new ArrayList<>();
////        pendingstudents = ao.viewPendingStudentApproval();
//        int i;
//        System.out.println("check");
//        for (i = 0; i<pendingstudents.size(); i++) {
//            String studID = pendingstudents.get(i);
//            System.out.println(studID);
//            System.out.println("Please press 1 to approve, else 0 to deny approval: ");
//            int stat = sc.nextInt();
//            sc.nextLine();
//            if(stat == 1){
//                ao.approveStudentRegistration(studID);
//                pendingstudents.remove(i);
//                i--;
//            }
//            System.out.println("Please press 1 to continue, else press 0 to exit: ");
//            stat = sc.nextInt();
//            sc.nextLine();
//            if(stat == 0){
//                break;
//            }
//
//        }
//        return;
//
//    }
    private void cancelCourseRegistration(){

    }
    /**
     *
     * Function to view registered students for a particular course
     */

    private void viewCourseStudentList(){
        System.out.println("Please enter Course ID to view Student List");
        String courseID = sc.nextLine();
        ArrayList<String> course_students = ao.viewCourseStudentList(courseID);
        System.out.println("Here is the list of students registered in course: " + courseID);
        for (String st:course_students){
            System.out.println("Student ID: " + st);
        }
        // fetch student list;
        return;

    }

    /**
     *
     * Function to view Grades of all Registered Students for a particular course
     */


    private void viewCourseGrades(){
        System.out.println("Please enter Course ID to view Grades");
        String courseID = sc.nextLine();
        ArrayList<ArrayList<String>> courseGrades = ao.viewCourseGrades(courseID);
        System.out.println("Here is the grade of students registered in course: " + courseID);
        for (ArrayList<String> i: courseGrades){
            System.out.println("Student ID: " + i.get(0) + "Grade: " + i.get(1));
        }
        return;

    }

    /**
     *
     * Function to Generate Grade Card
     */


    public void generateGradeCard() {
        //System.out.println("Please enter semester for which gradecard needs to be generated");
        //String semester= sc.nextLine();
        ao.generateGradeCard();
        System.out.println("Grade Cards generated successfully, now available for students to view!");
    }
}