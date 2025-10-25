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
        String department = panel.department.getText().trim();
        String gpa = panel.gpa.getText().trim();

        if(ID.isEmpty() || name.isEmpty() || age.isEmpty() || department.isEmpty() || gpa.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields. ");
            return;
        }

        if(!Validations.validateAge(age))
        {
            JOptionPane.showMessageDialog(null, "Invalid age. Age must be a number between 5 and 30.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try
        {
            String id = ID;
            int newage = Integer.parseInt(age);
            double newgpa = Double.parseDouble(gpa);

            Student student = new Student(id, name, newage, gender, department, newgpa);
            database.addStudent(student);
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null,"Age & GPA must be numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
