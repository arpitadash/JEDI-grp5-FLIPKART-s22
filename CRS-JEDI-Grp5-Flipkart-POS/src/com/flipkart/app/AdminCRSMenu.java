package com.flipkart.app;

import java.util.*;

import com.flipkart.service.AdminService;
import com.flipkart.bean.*;

public class AdminCRSMenu {
    private Scanner scanner = new Scanner(System.in);
    AdminService admin_service = AdminService.getInstance();
    private Context.ThrowErrorManager logger;

    public void createAdminMenu(String adminId) {
        System.out.println("*************Admin Menu**************");
        System.out.println("--------------------------------------");
        System.out.println("Kindly select one option from the menu");
        System.out.println("--------------------------------------");
        System.out.println("1. Edit Course Details in the course catalog");
        System.out.println("2. Add/Remove Professor");
        System.out.println("3. Add/Remove Admin");
        System.out.println("4. Enable/Disable Payment window");
        System.out.println("5. View available Courses for seat availability");
        System.out.println("6. Approve Student registration");
        System.out.println("7. View course wise student list");
        System.out.println("8. View Course wise grades");
        System.out.println("9. Generate Grade Card");
        System.out.println("10. Logout");
        int menuChoice = scanner.nextInt();
        scanner.nextLine();


        switch (menuChoice) {
            case 1:
                // Edit course details
                editCourseDetails();
                createAdminMenu(adminId);
                break;
            case 2:
                // add remove professor
                addRemoveProfessor();
                createAdminMenu (adminId);
                break;
//            case 3:
//                // add remove admin
//                addRemoveAdmin();
//                createAdminMenu ("adminx");
//                break;
//            case 4:
//                // enable/disbale payment window
//                enabledisableFeePaymentWindow();
//                createAdminMenu ("adminx");
//                break;
//            case 5:
//                // view available courses
//                viewAvailableCourses();
//                createAdminMenu ("adminx");
//                break;
//            case 6:
//                // approve student registration
//                approveStudentRegistration();
//                createAdminMenu ("adminx");
//                break;
//            case 7:
//                // view course wise student list - fetch from db
//                viewCourseStudentList();
//                createAdminMenu ("adminx");
//                break;
//            case 8:
//                // view course wise grades - fetch from db
//                viewCourseGrades();
//                createAdminMenu ("adminx");
//                break;
//            case 9:
//                // generate grade card;
//                generateGradeCard();
//                createAdminMenu ("adminx");
//                break;
//            case 10:
//                break;
        }
    }

    private void editCourseDetails() {
        try {
            while (true) {
                System.out.println("=======================================");
                System.out.println("Options : ");
                System.out.println("---------------------------------------");
                System.out.println("1 : Add course");
                System.out.println("2 : Remove course");
                System.out.println("3 : Exit");
                System.out.println("=======================================");
                int menuOption = scanner.nextInt();

                switch (menuOption) {
                    case 1:
                        // Add a new course in the catalog.
                        addCourse();
                        break;

                    case 2:
                        // Remove an existing course from the catalog.
                        removeCourse();
                        break;
                    case 3:
                        // update an existing course from the catalog.
                        return;
                    default:
                        System.out.println("Invalid input");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addCourse() {
        try {
            String courseID, course_name, course_instructor;
            int num_seats;
            System.out.println("-------------------------------------");
            System.out.println("Enter Course details");
            System.out.println("Course name: ");
            course_name = scanner.nextLine();
            System.out.println("Course ID: ");
            courseID = scanner.nextLine();
            System.out.println("Course Instructor: ");
            course_instructor = scanner.nextLine();
            System.out.println("Maximum number of Students");
            num_seats = scanner.nextInt();

            Course course = admin_service.addCourse(course_name, courseID, course_instructor, num_seats);
            if (course == null) {
                System.out.println("Course Was not added");
                System.out.println("=======================================");
            } else {
                System.out.println(course);
                System.out.println("Course Added Successfully!");

            }
        }
        catch (Exception e) {
            logger.error(e.getMessage());
        }
        return;
    }

    private void removeCourse(){
        try {
            String courseID;
            System.out.println("---------------------------");
            System.out.println("Enter Course ID: ");
            courseID = scanner.nextLine();
            admin_service.removeCourse(courseID);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addRemoveProfessor(){
        try {
            while(true) {
                System.out.println("=======================================");
                System.out.println("Options : ");
                System.out.println("---------------------------------------");
                System.out.println("1 : Add new professor");
                System.out.println("2 : Remove professor");
                System.out.println("3 : Update Existing professor Details");
                System.out.println("4 : Exit");
                System.out.println("=======================================");

                int menuOption = scanner.nextInt();

                switch(menuOption) {
                    case 1 :
                        // Add a new professor .
                        addProfessor();
                        break;

                    case 2 :
                        // Remove an existing professor.
                        removeProfessor();
                        break;
                    case 3 :
                        // Update an existing professor.
                        updateProfessor();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid input");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addProfessor(){
        try {
            String email, name, password, address, department, designation, contact;
            String joiningDate;
            System.out.println("=======================================");
            System.out.println("Kindly enter new professor details");
            System.out.println("---------------------------------------");
            System.out.println("Email: ");
            email = scanner.nextLine();
            System.out.println("Password: ");
            password = scanner.nextLine();
            System.out.println("Name: ");
            name = scanner.nextLine();
            System.out.println("Department: ");
            department = scanner.nextLine();
            System.out.println("Designation: ");
            designation = scanner.nextLine();
            System.out.println("Contact Number");
            contact = scanner.nextLine();
            System.out.println("Address");
            address = scanner.nextLine();
            System.out.println("Joining Date, Please enter in format dd-mm-yyyy");
            joiningDate = scanner.nextLine();

            Professor prof = admin_service.addProfessor(email, name, password, department, designation, joiningDate,address,contact);
            if(prof == null) {
                System.out.println("User Was not added");
                System.out.println("=======================================");
            }
            else {
                System.out.println("User Added Successfully!");
                System.out.println("=======================================");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void removeProfessor(){
        try {
            String professorID;
            System.out.println("---------------------------");
            System.out.println("Enter Professor ID: ");
            professorID = scanner.nextLine();
            admin_service.removeProfesssor(professorID);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}