package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SearchPanel extends JPanel{
    private JPanel panel1;
    private JTextField queryField;
    private JButton searchButton;
    private JTable resultsTable;
    private String[] columns = {"ID", "Name", "Gender", "Department", "GPA", "Age"};

    public SearchPanel(StudentDatabase db, HomePanel homePanel){

        this.setLayout(new BorderLayout());
        this.add(panel1, BorderLayout.CENTER);


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = queryField.getText().trim();
                if(query.isEmpty()) return;
                boolean isId = true;
                for(char c:query.toCharArray()) if(!Character.isDigit(c)) isId = false;
                Student[] students = {};
                if(isId) {
                    Student s = db.findStudent(Integer.parseInt(query));
                    if(s!=null) students = new Student[]{s};
                }
                else students = db.searchName(query).toArray(new Student[0]);

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
                resultsTable.setModel(new DefaultTableModel(data, columns){ //populate the table with my data
                    @Override
                    public boolean isCellEditable(int row, int column) {return false;} //khleeh view only
                });
            }
        });
        resultsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = resultsTable.getSelectedRow();
                if(e.getClickCount()==2 && row!=-1){
                    String id = (String) resultsTable.getModel().getValueAt(row, 0);
                    homePanel.switchPanel(new EditPanel(db, id, homePanel));
                }
            }
        });
    }
}
