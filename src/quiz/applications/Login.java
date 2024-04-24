package quiz.applications;

import javax.swing.*; // getContentPane, JFrame, JLabel, JTextField, JButton, JPasswordField, JOptionPane, ImageIcon, Color, Font,
import java.awt.event.*; 
import java.awt.*;  // ActionListener
// inheritence to extend JFrame class
// JFrame class is in swing package so we have to import swing
// and this swing class comes under javax package
// ActionListener comes under java awt event package
// graphical user interface

// encapsulation - jbuttons, jtextfield, jlabel etc encapsulate gui components

public class Login extends JFrame implements ActionListener {
    JButton proceed, back, register;
    JTextField tf_username, tf_password;
    // here we are defining it globally because we want to 
    // add a click event on it 
    // login class constructor
    // actionlistener interface of gui components 

    Login() {

        setTitle("Login Page"); // it will show on the top left corner of the frame
        // color of frame
        getContentPane().setBackground(Color.WHITE); //In Java Swing, 
        // the layer that is used to hold objects is called the content pane. 
        setLayout(null);
         // color class is in java awt package
        // to make a custome layout first we set the default layout as none
        JLabel image = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg")));
        image.setBounds(0, 0, 600, 500);
         // image 
        // classLoader is an abstract class which belongs to java.lang package

        
        add(image);

// heading 
        JLabel heading = new JLabel("Simple minds");
        heading.setBounds(750, 60, 300, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);
    // JLabel inherits JComponent class which is in javax package

    // username text field
        JLabel name = new JLabel("Username");
        name.setBounds(685, 150, 200, 25);
        name.setFont(new Font("Arial", Font.BOLD, 18));
        name.setForeground(new Color(30, 144, 254));
        add(name);

        tf_username = new JTextField();
        tf_username.setBounds(800, 150, 300, 25);
        tf_username.setFont(new Font("times New Roman", Font.BOLD, 18));
        add(tf_username);
        
// password text field
        JLabel password = new JLabel("Password");
        password.setBounds(685, 200, 200, 25);
        password.setFont(new Font("Arial", Font.BOLD, 18));
        password.setForeground(new Color(30, 144, 254));
        add(password);

        tf_password = new JTextField();
        tf_password.setBounds(800, 200, 300, 25);
        tf_password.setFont(new Font("times New Roman", Font.BOLD, 20));
        add(tf_password);
// proceed button
        proceed = new JButton("Proceed");
        proceed.setBounds(775, 270, 120, 25);
        proceed.setBackground(new Color(30, 144, 254));
        proceed.setForeground(Color.WHITE);
        proceed.addActionListener(this);
        add(proceed);

 //back button

        back = new JButton("Back");
        back.setBounds(955, 270, 120, 25);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
// click event on back button      
        back.addActionListener(this); // this can be used as an argument in the method
        add(back);
// new user text
        JLabel newUser = new JLabel("New user? ");
        newUser.setBounds(685, 330, 200, 25);
        newUser.setFont(new Font("Arial", Font.BOLD, 14));
        newUser.setForeground(new Color(30, 144, 254));
        add(newUser);
//  register button
        register = new JButton("Register");
        register.setBounds(770, 330, 120, 25);
        register.setBackground(new Color(30, 144, 254));
        register.setForeground(Color.WHITE);
        // click event on register button
        register.addActionListener(this); // here we have used this keyword as a parameter in the method
        add(register);
// frame 
//  // the default visibility of frame is false
// the frame will show at the top left corner of the screen
 // to set dimension of frame we have to use setSize() method
        setSize(1200, 500);
        setLocation(200, 200);
        setVisible(true);
    }
// if tap on back button we want to show the login page again 
    void showPane() {
        tf_password.setText(""); // when back then password will not be shown
        setVisible(true); // since we need to show the login form again on the screen
    }
 // this is the method of action listener interface which is implemented by the class
    // if we implement any interface in our class then all the unimplemented methods 
    // has to be overriden
@Override
    public void actionPerformed(ActionEvent ae) {
         // first we have to differentiate which button has been clicked
    // because same function has been called on both the buttons
        if (ae.getSource() == back) {
            setVisible(false); // if back button is used
        } else if (ae.getSource() == proceed) 
        //The getSource method is used in the actionPerformed method to determine which button was clicked.
            {  // if proceed button is used
                if (tf_username.getText().equals("")) // if the username is empty
                {
                    JOptionPane.showMessageDialog(this, "Please enter username first!", "Error",JOptionPane.ERROR_MESSAGE);
                } 
                else if (tf_password.getText().equals("")) // if password is empty
                { //joptionpane class is used to provide dialog boxes such as msg dialog box
                    JOptionPane.showMessageDialog(this, "Please enter password!", "Error", JOptionPane.ERROR_MESSAGE);
                } 
                // here this refers to the current object or instance of the class 
                // here it refers to the current jframe instance, which is the parent component for the dialog
                else // if both text fiels are filled
                {
                    try { // we hav3 eused exception handling here
                        // The validate method can be called each time you are about to 
                        // throw the object to the server for some processing, and if it returns true , you can go ahead.

                        if (Credentials.validate(tf_username.getText(), tf_password.getText()))  
                         {
                            setVisible(false);
                            new Rules(tf_username.getText(), this);
                        } 
                        else 
                        {
                            JOptionPane.showMessageDialog(this, "Incorrect password!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                } 
                    catch(FileDeletedException fdEx) 
                    {
                        JOptionPane.showMessageDialog(this, fdEx, "Error", JOptionPane.ERROR_MESSAGE);
                    } 
                    catch (UserDoesNotExistsException udeEx)
                    {
                        JOptionPane.showMessageDialog(this, udeEx, "Error", JOptionPane.ERROR_MESSAGE);
                    }
            }
        } 
            else if (ae.getSource() == register) 
            {
            setVisible(false);
            new Register(this);
            }
    }

    public static void main(String[] args) {
        new Login();

        // a new object named login, annonymous object
        // we want that as soon as i run the class, a frame will show up
        // class ko run karte se hi main method call hota hai
        //class ka object banate se hi constructor call hota hai
        // only if we write the code part in constructor we will gonna see the code 
        // just after calling the class

        // Anonymous Object - the memory assigned for anonymous object is in only heap area
        // and not in stack
        // if we want to create a frame and show it on the screen we have to create an object of frame class
        // anonymous objects can be called once only
        // if we want to call the object again we have to create a new object
        // it is not a referenced object
    }

}
