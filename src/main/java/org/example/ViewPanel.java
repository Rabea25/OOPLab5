package org.example;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;

public class ViewPanel extends JPanel {

    private JTable StudentsTable;
    private JPanel root;

    public ViewPanel(StudentDatabase db, HomePanel homePanel) {

        this.setLayout(new BorderLayout());
        this.add(root, BorderLayout.CENTER);

        String[] columns = {"ID", "Name", "Gender", "Department", "GPA", "Age"};
        Student[] students = db.getStudents().toArray(new Student[0]);
        Object[][] data = new Object[students.length][columns.length];
        for (int i = 0; i < students.length; i++) {
            Student s = students[i];
            data[i][0] = s.getId();
            data[i][1] = s.getName();
            data[i][2] = s.getGender();
            data[i][3] = s.getDepartment();
            data[i][4] = s.getGpa();
            data[i][5] = s.getAge();
        }
        StudentsTable.setModel(new DefaultTableModel(data, columns){ //populate the table with my data
            @Override
            public boolean isCellEditable(int row, int column) {return false;} //khleeh view only
        });
        StudentsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = StudentsTable.getSelectedRow();
                if(e.getClickCount()==2 && row!=-1){
                    String id = (String) StudentsTable.getModel().getValueAt(row, 0);
                    homePanel.switchPanel(new EditPanel(db, id, homePanel));
                }
            }
        });
    }


}
