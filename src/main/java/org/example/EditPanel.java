package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class EditPanel extends JPanel {

    private JPanel root;
    private JLabel idLabel;
    private JTextField newName;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JLabel studentID;
    private JComboBox departmentComboBox;
    private JTextField newAge;
    private JTextField newGPA;
    private JButton saveButton;
    private JButton cancelButton;
    private JButton deleteButton;
    private ButtonGroup gender;
    private JPanel panel1;


    public EditPanel(StudentDatabase db, String id, HomePanel homePanel){
        this.setLayout(new BorderLayout());
        this.add(root, BorderLayout.CENTER);

        Student s = db.findStudent(Integer.parseInt(id));

        studentID.setText(""+id);
        newName.setText(s.getName());

        gender = new ButtonGroup();
        gender.add(maleRadioButton);
        gender.add(femaleRadioButton);
        maleRadioButton.setActionCommand("Male");
        femaleRadioButton.setActionCommand("Female");
        if(Objects.equals(s.getGender(), "Male")) maleRadioButton.setSelected(true);
        else femaleRadioButton.setSelected(true);

        String[] departments = {"Electrical Engineering", "Mechanical Engineering", "Computer Engineering", "Civil Engineering", "Electronics & Communication Engineering", "Architectural Engineering"};
        for(String d:departments) departmentComboBox.addItem(d);
        departmentComboBox.setSelectedItem(s.getDepartment());

        newGPA.setText(""+s.getGpa());
        newAge.setText(""+s.getAge());

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homePanel.switchPanel(new ViewPanel(db, homePanel));
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = newName.getText().trim();
                String age = newAge.getText().trim();
                String gpa = newGPA.getText().trim();
                if(!Validations.validateName(name)) {
                    JOptionPane.showMessageDialog(null, "Invalid Name.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(!Validations.validateAge(age)){
                    JOptionPane.showMessageDialog(null, "Invalid age.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(!Validations.validateGpa(gpa)){
                    JOptionPane.showMessageDialog(null, "Invalid GPA.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    System.out.println(gender.getSelection().getActionCommand());
                    db.editStudent(new Student(id, name,Integer.parseInt(age), gender.getSelection().getActionCommand(), departmentComboBox.getSelectedItem().toString(), Float.parseFloat(gpa)));
                    homePanel.switchPanel(new ViewPanel(db, homePanel));
                }

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Student?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION){
                    db.deleteStudent(Integer.parseInt(id));
                    homePanel.switchPanel(new ViewPanel(db, homePanel));
                }
            }
        });

    }
}
