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
import javax.swing.text.JTextComponent;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm extends JFrame {
    private static JTextField athleteField;
    private static JTextField passField;
    private static JPasswordField ageField;
    private static JTextField gender;
    private static JTextField event;
    private static JTextField nationality;
    private static JTextField contactinfo;
    private RegistrationModel model;

    public RegistrationForm(RegistrationModel model) {
        this.model = model;

        setTitle("Registration Form");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 4));

        panel.add(new JLabel("Athlete:"));
        athleteField = new JTextField();
        panel.add(athleteField);

        panel.add(new JLabel("Password:"));
        passField = new JPasswordField();
        panel.add(passField);

        panel.add(new JLabel("Age:"));
        JTextField ageField = new JTextField();
        panel.add(ageField);
        
        panel.add(new JLabel("Gender:"));
        JTextField genderField = new JTextField();
        panel.add(genderField);
        
        panel.add(new JLabel("Event:"));
        JTextField eventField = new JTextField();
        panel.add(eventField);
        
        panel.add(new JLabel("Nationality:"));
        JTextField nationalityField = new JTextField();
        panel.add(nationalityField);
        
        panel.add(new JLabel("Contact:"));
        JTextField contactinfoField = new JTextField();
        panel.add(contactinfoField);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerathlete();
            }
        });
        panel.add(registerButton);

        add(panel);
        setVisible(true);
    }

    /**
     * 
     */
    private static void registerathlete() {
        String athlete = athleteField.getText();
        String pass = new String(passField.getUIClassID());
        String age = ageField.getName();
        String gender = genderField.getText();
        String event = eventField.getText();
        String nationality = nationalityField.getText();
        String contactinfo = contactinfoField.getText();

        // Check if the email is already registered
        if (RegistrationModel.isathleteRegistered(athlete)) {
            JOptionPane.showMessageDialog(null, "Athlete already registered", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Inside the action listener for the "Register" button
        String errorMessage = RegistrationModel.registerathlete(athlete, pass, age, gender, event, nationality, contactinfo);
        if (errorMessage.startsWith("Error")) {
            JTextComponent errorMessageLabel = new JTextField(); //views.UserRegistrationForm.registerUser();
            errorMessageLabel.setText(errorMessage);
            //errorMessageLabel.setText(errorMessage); // Display error message in a label
        } else {
            JOptionPane.showMessageDialog(null, errorMessage, "Success", JOptionPane.INFORMATION_MESSAGE); // Or display                                                                                            //                                                                       // using                                                                                               // JOptionPane
        }

        RegistrationModel.registerathlete(athlete, pass, age, gender, event, nationality, contactinfo);
    }

    public static void main(String[] args) {
        RegistrationModel model = new RegistrationModel();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistrationForm(model);
            }
        });
    }

    private static class genderField {

        private static String getText() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public genderField() {
        }
    }

    private static class eventField {

        private static String getText() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public eventField() {
        }
    }

    private static class nationalityField {

        private static String getText() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public nationalityField() {
        }
    }

    private static class contactinfoField {

        private static String getText() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public contactinfoField() {
        }
    }
}

