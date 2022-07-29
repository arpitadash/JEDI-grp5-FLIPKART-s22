package com.flipkart.bean;

<<<<<<< HEAD
public class Professor {
    private String professorID;
    private String department;


    /**
     * @return the professorID
     */
    public String getProfessorID() {
        return professorID;
    }
    /**
     * @param professorID the professorID to set
     */
    public void setProfessorID(String professorID) {
        this.professorID = professorID;
    }
    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }
    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }
=======
public class Professor extends User{
    private String professorId;
    private String department;
    private String designation;
    public Professor(String joinDate,String email, String name, String role, String password, String address, String contactNum, String professorId, String department, String designation)
    {
        super(email,password,name,role,joinDate,contactNum,address);
        this.professorId = professorId;
        this.department = department;
        this.designation = designation;
    }

    public Professor(){

    }

    public void setProfessorId(String professorId){
        this.professorId = professorId;
    }
    public String getProfessorId(){
        return professorId;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    public String getDepartment(){
        return department;
    }
    public void setDesignation(String designation){
        this.designation = designation;
    }
    public String getDesignation(){
        return designation;
    }
>>>>>>> dfa90a1b0b748b9c74bbe61ae7b76d62f5c34b35
}
