package com.flipkart.bean;

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

}
