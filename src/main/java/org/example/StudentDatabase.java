package org.example;

import java.io.*;
import java.util.*;
import javax.swing.*;

public class StudentDatabase {
    private static final String filename = "Students.txt";
    private ArrayList<Student> students = new ArrayList<>();

    public StudentDatabase()
    {
        loadStudents();
    }

    public void addStudent(Student s)
    {
        students.add(s);
        saveStudents();
        JOptionPane.showMessageDialog(null, "Student added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void deleteStudent(int id)
    {
        for(int i = 0; i <students.size(); i++)
        {
            Student s = students.get(i);
                if(Integer.parseInt(s.getId()) == id)
                {
                    students.remove(i);
                    saveStudents();
                    JOptionPane.showMessageDialog(null, "Student deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
        }
        JOptionPane.showMessageDialog(null, "Student not found. ", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void editStudent(Student updatedstudent)
    {
        for(Student s : students)
        {
            if(s.getId() == updatedstudent.getId())
            {
                s.setName(updatedstudent.getName());
                s.setAge(updatedstudent.getAge());
                s.setGender(updatedstudent.getGender());
                s.setDepartment(updatedstudent.getDepartment());
                s.setGpa(updatedstudent.getGpa());

                saveStudents();
                JOptionPane.showMessageDialog(null, "Student updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
    }


    public ArrayList<Student> getStudents() { return new ArrayList<>(students); }


    public Student findStudent(int id)
    {
        for (Student s : students) if(Integer.parseInt(s.getId()) == id) return s;
        return null;
    }


    public ArrayList<Student> searchName(String name)
    {
        ArrayList<Student> result = new ArrayList<>();
        for (Student s: students)
        {
            if(s.getName().toLowerCase().contains(name.toLowerCase())) result.add(s);
        }
        return result;
    }

    public ArrayList<Student> searchId(String partialId){
        ArrayList<Student> result = new ArrayList<>();
        for(Student s : students){
            if(s.getId().contains(partialId)) result.add(s);
        }
        return result;
    }

    private void saveStudents()
    {
        try (BufferedWriter writes = new BufferedWriter(new FileWriter(filename)))
        {
            for (Student s : students)
            {
                writes.write(s.lineRepresentation());
                writes.newLine();
            }
        } catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, "Error saving student.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadStudents()
    {
        students.clear();
        try(BufferedReader reads = new BufferedReader((new FileReader(filename))))
        {
            String line;
            while ((line = reads.readLine()) != null)
                students.add(Student.lineToStudent(line));
        } catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Error opening file. File might not exist.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }








}