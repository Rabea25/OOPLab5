package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePanel extends JFrame {
    private JLabel title;
    private JButton homeButton;
    private JButton logoutButton;
    private JButton viewButton;
    private JButton searchButton;
    private JButton addButton;
    private JButton deleteButton;
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
                AddPanel addPanel = new AddPanel();
                AddPanelController c = new AddPanelController(addPanel, db);
                switchPanel(addPanel);
            }
        });
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(new ViewPanel(db, HomePanel.this));
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(new SearchPanel(db, HomePanel.this));
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(contentPanel, "Logging out....");
                //JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(contentPanel);
                //currentFrame.dispose();
                HomePanel.this.dispose();


                loginPanel loginpanel = new loginPanel(db);
                //login panel already creates its own frame, this causes there an additional frame that just stays
//                JFrame loginFrame = new JFrame("Login");
//                loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                loginFrame.setSize(500, 400);
//                loginFrame.setLocationRelativeTo(null);
//                loginFrame.setContentPane(new loginPanel(db).getRootPanel());
//                loginFrame.setVisible(true);

            }
        });
    }

    public void switchPanel(JPanel panel) {
        contentPanel.removeAll();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(panel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

}
