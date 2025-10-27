package org.example;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;


public class AddPanelController {
    private AddPanel panel;
    private StudentDatabase database;

    public AddPanelController(AddPanel panel, StudentDatabase database) {
        this.panel = panel;
        this.database = database;

        panel.submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {addingStudent();}
        });
    }

    private void addingStudent()
    {
        String ID = panel.ID.getText().trim();
        String name = panel.name.getText().trim();
        String age = panel.age.getText().trim();
        String gender = (String) panel.gender.getSelectedItem();
        String department = (String) panel.department.getSelectedItem();
        String gpa = panel.gpa.getText().trim();

        if(ID.isEmpty() || name.isEmpty() || age.isEmpty() || gpa.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields. ");
            return;
        }

        if(!Validations.validateName(name))
        {
            JOptionPane.showMessageDialog(null, "Invalid name. must enter full name consisting of english letters only.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(!Validations.validateAge(age))
        {
            JOptionPane.showMessageDialog(null, "Invalid age. Age must be a number between 5 and 30.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(!Validations.validateGpa(gpa))
        {
            JOptionPane.showMessageDialog(null, "Invalid GPA. GPA must be a number between 0.00 and 4.00.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!Validations.validateID(Integer.parseInt(ID))){
            JOptionPane.showMessageDialog(null, "Invalid ID. ID must be a number between 100 and 99999", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try
        {
            int newage = Integer.parseInt(age);
            float newgpa = Float.parseFloat(gpa);
            int intid = Integer.parseInt(ID);

            if(database.findStudent(intid)!=null){
                JOptionPane.showMessageDialog(null, "ID already in use.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }


            Student student = new Student(String.valueOf(intid), name, newage, gender, department, newgpa);
            database.addStudent(student);
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null,"Age, ID & GPA must be numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
