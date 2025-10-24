package org.example;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePanel {
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


    public HomePanel() {
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(welcomePanel);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(AddPanel);
            }
        });
        editDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(EditDeletePanel);
            }
        });
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(ViewContent);
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(SearchPanel);
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
        contentPanel.add(panel);
        contentPanel.revalidate();
        contentPanel.repaint();
    }



}
