package org.example;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class HomePanel extends JFrame {
    private JLabel title;
    private JButton homeButton;
    private JButton logoutButton;
    private JButton editDeleteButton;
    private JButton viewButton;
    private JButton addButton;
    private JButton searchButton;
    private JPanel contentPanel;
    private JPanel topPanel;
    private JTextArea welcomeField;
    private JPanel welcomePanel;
    private JPanel rootPanel;


    public HomePanel(StudentDatabase db) {
        //$$$setupUI$$$();
        this.setContentPane(rootPanel);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(welcomePanel);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //switchPanel(AddPanel);
            }
        });
        editDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //switchPanel(EditDeletePanel);
            }
        });
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(new ViewPanel(db));
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //switchPanel(SearchPanel);
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(contentPanel, "Logging out....");

            }
        });
    }

    private void switchPanel(JPanel panel) {
        contentPanel.removeAll();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(panel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }


}
