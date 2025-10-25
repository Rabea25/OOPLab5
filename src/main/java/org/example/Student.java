package org.example;

public class Student {
    private String studentId;
    private String fullName;
    private int age;
    private String gender;
    private String department;
    private float gpa;

    public Student(String studentId, String fullName, int age, String gender, String department, float gpa){
        this.studentId = studentId ;
        this.fullName = fullName ;
        this.age = age ;
        this.gender = gender ;
        this.department = department ;
        this.gpa = gpa ;
    }


   public String lineRepresentation() {
        return studentId + "," + fullName + "," + age + "," + gender + "," + department + "," + gpa;
   }

    public static Student lineToStudent(String line){
        String[] parts = line.split(",");
        if (parts.length != 6){
            System.out.println("String must have 6 sections");
            return null ;
        }

        String id = parts[0];
        String name =parts[1];
        int age = Integer.parseInt(parts[2]);
        String gender = parts[3];
        String department = parts[4];
        float gpa = Float.parseFloat(parts[5]);
        return new Student(id, name, age , gender,department, gpa);
    }




    // Getters and Setters
    public String getId() {
        return studentId;
    }
    public void setId(String id) {
        this.studentId = id;
    }
    public String getName() {
        return fullName;
    }
    public void setName(String name) {
        this.fullName = name;
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
    public float getGpa() {
        return gpa;
    }
    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
}
