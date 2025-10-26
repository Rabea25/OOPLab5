package org.example;
import javax.swing.*;
import java.awt.*;


public class loginPanel {
    JFrame frame = new JFrame("Student Management System");
    private JPanel Loginpanel;
    private JLabel Username;
    private JTextField Usernamefield;
    private JPasswordField passwordField1;
    private JButton logInButton;

    public loginPanel(StudentDatabase db) {
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(Loginpanel);

        logInButton.addActionListener(e -> {
            String username = Usernamefield.getText();
            String password = new String(passwordField1.getPassword());

            if (username.equalsIgnoreCase("1") && password.equals("1")) {
                JOptionPane.showMessageDialog(frame, "Going to home page", "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(Loginpanel);
                currentFrame.dispose();

                JFrame homeFrame = new HomePanel(db);
                homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                homeFrame.setSize(900, 600);
                homeFrame.setLocationRelativeTo(null);
                //homeFrame.setContentPane(new HomePanel(db).getRootPanel());
                homeFrame.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public JPanel getRootPanel() {
        return Loginpanel;
    }
}





