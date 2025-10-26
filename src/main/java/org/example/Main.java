package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        StudentDatabase db = new StudentDatabase();
        loginPanel loginpanel = new loginPanel(db);
    }
}