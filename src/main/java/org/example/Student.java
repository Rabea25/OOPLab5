package org.example;
import java.io.*;
import java.util.*;

public class Student {
    private String id;
    private String name;
    private int age;
    private String gender;
    private String department;
    private double gpa;

    public Student(String id, String name, int age, String gender, String
            department, double gpa){
        this.id = id ;
        this.name = name ;
        this.age = age ;
        this.gender = gender ;
        this.department = department ;
        this.gpa = gpa ;
    }

    public boolean validateData(){
        if(id == null || id.length()<3 || id.length()>6){
            return false ;
        }
        if (name == null || name.isEmpty() ){
            return false ;
        }
        if (age < 0 || age > 80) {
            return false ;
        }
        if (!gender.equalsIgnoreCase("Male")  && !gender.equalsIgnoreCase("Female") ){
            return false ;
        }
        if (department == null || department.isEmpty()){
            return false ;
        }
        if (gpa < 0.0 || gpa > 4.0){
            return false ;
        }
    return true ;}

   public String toFileString() {
        return id + "," + name + "," + age + "," + gender + "," + department + "," + gpa;
   }

    public static Student fromFileString(String line){
        String[] parts = line.split(",");
        if (parts.length != 6){
            System.out.println("String must have 6 sections");
            return null ;}

        String id = parts[0];
        String name =parts[1];
        int age = Integer.parseInt(parts[2]);
        String gender = parts[3];
        String department = parts[4];
        double gpa = Double.parseDouble(parts[5]);
        return new Student(id, name, age , gender,department, gpa);
    }




    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;   }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
