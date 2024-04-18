/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg134517;

/**
 *
 * @author PC
 */
import javax.swing.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class LoginView extends JFrame {
    private JTextField athleteField;
    private JPasswordField passField;
    private JButton loginButton;

    private static final int SESSION_TIMEOUT = 10 * 60 * 1000; // 10 minutes in milliseconds
    private Timer sessionTimer;

    public LoginView() {
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 150);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel usernameLabel = new JLabel("Athlete:");
        usernameLabel.setBounds(10, 10, 80, 25);
        panel.add(usernameLabel);

        athleteField = new JTextField();
        athleteField.setBounds(100, 10, 160, 25);
        panel.add(athleteField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(10, 40, 80, 25);
        panel.add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(100, 40, 160, 25);
        panel.add(passField);

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 80, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                startSessionTimer();

                String athlete = athleteField.getText();
                String pass = new String(passField.getPassword());

                // Call the login method from your model
                String errorMessage = Login.authenticate(athlete, pass); // log in from here
                if (errorMessage.startsWith("Error")) {
                    JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Login successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                    // Redirect to main application window or perform other actions
                }
            }
        });

        add(panel);
        setVisible(true);
    }

    // Log out user if they stay inactive for 10 minutes
    private void startSessionTimer() {
        if (sessionTimer != null && sessionTimer.isRunning()) {
            sessionTimer.stop();
        }
        sessionTimer = new Timer(SESSION_TIMEOUT, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform logout logic here
                // For example, redirect to the login page or display a logout message
                JOptionPane.showMessageDialog(LoginView.this, "Session timeout. Logging out...");
                // Stop the timer
                sessionTimer.stop();
            }
        });
        sessionTimer.setRepeats(false); // Only run once
        sessionTimer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginView();
            }
        });
    }
}
