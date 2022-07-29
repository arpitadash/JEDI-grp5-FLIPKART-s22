package com.flipkart.bean;
import java.util.*;

public class User {
    private String email;
    private String password;
    private String name;
    private String role;
    private String joinDate;
    private String contactNum;
    private String address;

    public User(String email, String password, String name, String role, String joinDate, String contactNum, String address){
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
        this.joinDate = joinDate;
        this.contactNum = contactNum;
        this.address = address;
    }

    public User(){

    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setRole(String role){
        this.role = role;
    }
    public String getRole(){
        return role;
    }
    public void setJoinDate(String joinDate){
        this.joinDate = joinDate;
    }
    public String getJoinDate(){
        return joinDate;
    }
    public void setContactNum(String contactNum){
        this.contactNum = contactNum;
    }
    public String getContactNum(){
        return contactNum;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }
}
