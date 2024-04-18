package quiz.applications;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    JButton closeButton, playAgain;

    Score(String name, int score) {
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        // ImageIcon i3 = new ImageIcon(i2);
        // JLabel image = new JLabel(i3);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(0, 100, 300, 250);
        add(image);

        JLabel heading = new JLabel("Thankyou " + name + " for playing Simple Minds");
        heading.setBounds(45, 30, 700, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(heading);

        JLabel lblscore = new JLabel("Your score is " + score);
        lblscore.setBounds(350, 200, 300, 30);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(lblscore);

        playAgain = new JButton("Play Again");
        playAgain.setBounds(380, 270, 120, 30);
        playAgain.setBackground(new Color(30, 144, 255));
        playAgain.setForeground(Color.WHITE);
        playAgain.addActionListener(this);
        add(playAgain);
        
        closeButton = new JButton("Close");
        closeButton.setBounds(380, 320, 120, 30);
        closeButton.setBackground(new Color(30, 144, 255));
        closeButton.setForeground(Color.WHITE);
        closeButton.addActionListener(this);
        add(closeButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == closeButton) {
            setVisible(false);
        } else if (ae.getSource() == playAgain) {
            setVisible(false);
            new Login();
        } 
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}