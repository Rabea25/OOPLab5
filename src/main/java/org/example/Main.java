package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        StudentDatabase db = new StudentDatabase();
        JFrame mainWindow = new HomePanel(db);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(600, 600);
        mainWindow.setVisible(true);

    }
}