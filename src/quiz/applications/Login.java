package quiz.applications;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Login extends JFrame implements ActionListener {
    JButton proceed, back, register;
    JTextField tf_username, tf_password;

    Login() {
        setTitle("Login Page");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel image = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg")));
        image.setBounds(0, 0, 600, 500);
        add(image);

        JLabel heading = new JLabel("Simple minds");
        heading.setBounds(750, 60, 300, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        JLabel name = new JLabel("Username");
        name.setBounds(685, 150, 200, 25);
        name.setFont(new Font("Arial", Font.BOLD, 18));
        name.setForeground(new Color(30, 144, 254));
        add(name);

        tf_username = new JTextField();
        tf_username.setBounds(800, 150, 300, 25);
        tf_username.setFont(new Font("times New Roman", Font.BOLD, 18));
        add(tf_username);

        JLabel password = new JLabel("Password");
        password.setBounds(685, 200, 200, 25);
        password.setFont(new Font("Arial", Font.BOLD, 18));
        password.setForeground(new Color(30, 144, 254));
        add(password);

        tf_password = new JTextField();
        tf_password.setBounds(800, 200, 300, 25);
        tf_password.setFont(new Font("times New Roman", Font.BOLD, 20));
        add(tf_password);

        proceed = new JButton("Proceed");
        proceed.setBounds(775, 270, 120, 25);
        proceed.setBackground(new Color(30, 144, 254));
        proceed.setForeground(Color.WHITE);
        proceed.addActionListener(this);
        add(proceed);

        back = new JButton("Back");
        back.setBounds(955, 270, 120, 25);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        JLabel newUser = new JLabel("New user? ");
        newUser.setBounds(685, 330, 200, 25);
        newUser.setFont(new Font("Arial", Font.BOLD, 14));
        newUser.setForeground(new Color(30, 144, 254));
        add(newUser);

        register = new JButton("Register");
        register.setBounds(770, 330, 120, 25);
        register.setBackground(new Color(30, 144, 254));
        register.setForeground(Color.WHITE);
        register.addActionListener(this);
        add(register);

        setSize(1200, 500);
        setLocation(200, 200);
        setVisible(true);
    }

    void showPane() {
        tf_password.setText("");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
        } else if (ae.getSource() == proceed) {
            if (tf_username.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter username first!", "Error",JOptionPane.ERROR_MESSAGE);
            } else if (tf_password.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter password!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    if (Credentials.validate(tf_username.getText(), tf_password.getText())) {
                        setVisible(false);
                        new Rules(tf_username.getText(), this);
                    } else {
                        JOptionPane.showMessageDialog(this, "Incorrect password!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch(FileDeletedException fdEx) {
                    JOptionPane.showMessageDialog(this, fdEx, "Error", JOptionPane.ERROR_MESSAGE);
                } catch (UserDoesNotExistsException udeEx) {
                    JOptionPane.showMessageDialog(this, udeEx, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (ae.getSource() == register) {
            setVisible(false);
            new Register(this);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
