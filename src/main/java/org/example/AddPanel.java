package org.example;

import javax.swing.*;
import java.awt.*;

public class AddPanel extends JPanel {
        JTextField ID = new JTextField(10);
        JTextField name = new JTextField(20);
        JTextField age = new JTextField(5);
        JComboBox<String> gender = new JComboBox<>(new String[]{"Male", "Female"});
        JTextField department = new JTextField(15);
        JTextField gpa = new JTextField(5);
        JButton submit = new JButton("Add Student");

        public AddPanel()
        {
            setLayout(new GridLayout(7,2,2,5));
            add(new JLabel("Student ID: "));
            add(ID);
            add(new JLabel("Full Name"));
            add(name);
            add(new JLabel("Age: "));
            add(age);
            add(new JLabel("Gender: "));
            add(gender);
            add(new JLabel("Department: "));
            add(department);
            add(new JLabel("GPA: "));
            add(gpa);
            add(new JLabel(""));
            add(submit);
        }
}
