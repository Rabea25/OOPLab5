package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Objects;

public class ViewPanel extends JPanel {

    private JTable StudentsTable;
    private JPanel root;
    private JComboBox sortType;

    public ViewPanel(StudentDatabase db, HomePanel homePanel) {

        this.setLayout(new BorderLayout());
        this.add(root, BorderLayout.CENTER);

        sortType.addItem("id");
        sortType.addItem("gpa");
        sortType.addItem("name");
        sortType.setSelectedItem("id");

        Student[] students = db.getStudents().toArray(new Student[0]);

        Arrays.sort(students, (a, b) -> a.getId().compareTo(b.getId()));
        populateTable(StudentsTable, students);

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
        sortType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = sortType.getSelectedItem().toString();
                if(Objects.equals(selected, "id")){
                    Arrays.sort(students, (a, b) -> a.getId().compareTo(b.getId()));
                    populateTable(StudentsTable, students);
                }
                else if(Objects.equals(selected, "gpa")){
                    Arrays.sort(students, (a, b) -> Float.compare(a.getGpa(), b.getGpa()));
                    populateTable(StudentsTable, students);
                }
                else{
                    Arrays.sort(students, (a, b) -> a.getName().compareTo(b.getName()));
                    populateTable(StudentsTable, students);
                }
            }
        });
    }

    public void populateTable(JTable StudentsTable, Student[] students){
        String[] columns = {"ID", "Name", "Gender", "Department", "GPA", "Age"};
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
    }


}
