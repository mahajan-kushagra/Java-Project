package quiz.applications;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Register extends JFrame {

    Login login;

    public Register(Login l) {
        setTitle("Registration Form");
        setSize(600, 500); // Set initial size
        setLocation(400, 200); // Set location

        login = l;
        // Create main panel with GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        setContentPane(mainPanel);

        // Create blue background panel
        JPanel bluePanel = new JPanel(new GridBagLayout());
        bluePanel.setBackground(new Color(30, 144, 254)); // Light blue color

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        JTextField usernameField = new JTextField(20);
        // usernameField.setBounds(200,300,200,30);
        JTextField passwordField = new JTextField(20);
        // passwordField.setBounds(200,350,200,30);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usernameField.getText().equals("")) {
                    JOptionPane.showMessageDialog(registerButton, "Please enter username first!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else if (passwordField.getText().equals("")) {
                    JOptionPane.showMessageDialog(registerButton, "Please enter password!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        if (Credentials.addUser(usernameField.getText(), passwordField.getText())) {
                            JOptionPane.showMessageDialog(registerButton, "User registered successfully!",
                                    "Registration successful", JOptionPane.INFORMATION_MESSAGE);
                                    setVisible(false);
                                    login.showPane();
                        }
                    } catch (FileDeletedException fdEx) {
                        JOptionPane.showMessageDialog(registerButton, fdEx, "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (UserAlreadyExistsException uaeEx) {
                        JOptionPane.showMessageDialog(registerButton, uaeEx, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        JLabel alreadyRegisteredLabel = new JLabel("Already registered?");
        
        JButton loginButton = new JButton("Login");
        // Add action listener for the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                l.showPane();
            }
        });

        // Add components to bluePanel using GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        bluePanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        bluePanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        bluePanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        bluePanel.add(passwordField, gbc);

        // Create panel for register and login button to set its size
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(registerButton);

        JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        loginPanel.add(alreadyRegisteredLabel);
        loginPanel.add(loginButton);

        // Add bluePanel and buttonPanel to mainPanel using GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(bluePanel, gbc);
        
        gbc.gridy = 1;
        mainPanel.add(buttonPanel, gbc);
        
        // Add loginPanel to mainPanel using GridBagConstraints
        gbc.gridy = 2;
        mainPanel.add(loginPanel, gbc);
        
        setVisible(true);
    }
}