package org.example;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

public class ViewPanel extends JPanel {

    private JTable StudentsTable;
    private JPanel root;

    public ViewPanel(StudentDatabase db) {
        //$$$setupUI$$$();

        this.setLayout(new BorderLayout());
        this.add(root, BorderLayout.CENTER);

        String[] columns = {"ID", "Name", "Gender", "Department", "GPA", "Age"};
        Student[] students = db.getAllStudents("none");
        Object[][] data = new Object[students.length][columns.length];
        for (int i = 0; i < students.length; i++) {
            Student s = students[i];
            data[i][0] = s.getStudentId();
            data[i][1] = s.getFullName();
            data[i][2] = s.getGender();
            data[i][3] = s.getDepartment();
            data[i][4] = s.getGPA();
            data[i][5] = s.getAge();
        }
        StudentsTable.setModel(new DefaultTableModel(data, columns){ //populate the table with my data
            @Override
            public boolean isCellEditable(int row, int column) {return false;} //khleeh view only
        });
    }


}
