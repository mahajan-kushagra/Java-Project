package quiz.applications;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Login extends JFrame implements ActionListener {
    JButton proceed, back;
    JTextField tfname;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        // JLabel image = new JLabel(i1);
        JLabel image = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg")));
        image.setBounds(0, 0, 600, 500);
        add(image);

        JLabel heading = new JLabel("Simple minds");
        heading.setBounds(750, 60, 300, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        JLabel name = new JLabel("Enter your name");
        name.setBounds(810, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(new Color(30, 144, 254));
        add(name);

        tfname = new JTextField();
        tfname.setBounds(735, 200, 300, 25);
        tfname.setFont(new Font("times New Roman", Font.BOLD, 20));
        add(tfname);

        proceed = new JButton("Proceed");
        proceed.setBounds(735, 270, 120, 25);
        proceed.setBackground(new Color(30, 144, 254));
        proceed.setForeground(Color.WHITE);
        proceed.addActionListener(this);
        add(proceed);

        back = new JButton("Back");
        back.setBounds(915, 270, 120, 25);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(1200, 500);
        setLocation(200, 200);
        setVisible(true);
    }

    void showPane() {
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == proceed) {
            if (tfname.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter your name first!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // String name = tfname.getText();
                setVisible(false);
                new Rules(tfname.getText(), this);
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
