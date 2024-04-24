package quiz.applications;

import java.awt.*;
import javax.swing.*;//jframe class is in this package
import java.awt.event.*;//color class is in this package,ActionListener interface that comes in awt.event package

public class Quiz extends JFrame implements ActionListener {//actionListener handles the event like we click on next buttons or submit
    // actionListner we get form event package
    String questions[][] = new String[10][5];//we have created a 2d array for storing questions of string type each question in a row has 5 options in the form of column
    String answers[][] = new String[10][2];//storing answers in the form of 2d array with 2 column 1 for correct options we can make 10*1 array also
    String useranswers[][] = new String[10][1];//user answers are stored
    JRadioButton opt1, opt2, opt3, opt4;
    JLabel qno, question;//globally declared
    ButtonGroup groupOptions;
    JButton next, submit;
    public static int timer = 15;//static variable -it is a class variable it is created only once and shared by all objects of the class.it is use for memory management
    public static int ans_given = 0;//flag value initially to 0 and check it the user has answered any option or not
    public static int count = 0;
    public static int score = 0;
    String name;//g;lobally declared

    Quiz(String name) {
        this.name = name;//stored globally for the other class to use
        setBounds(50, 0, 1440, 850);  

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        // JLabel image = new JLabel(i1);
        JLabel image = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg")));
        image.setBounds(0, 0, 1440, 392);
        add(image);

        qno = new JLabel(); //values are inserted dynamically
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));//created a font class object
        add(qno);

        question = new JLabel("");
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        opt1 = new JRadioButton();//for the selection of option
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        // grouping all 4 radio buttons to restrict the user to select only one option at a time
        groupOptions = new ButtonGroup(); 
        groupOptions.add(opt1);
        groupOptions.add(opt2);
        groupOptions.add(opt3);
        groupOptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));//if we want to set values inn rgv formet and color class object we have to create
        next.setForeground(Color.WHITE);
       
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(1100, 630, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        setVisible(true);
        start(count);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {//if next button is called then repaint 
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            ans_given = 1;
            if (groupOptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                // getActionCommand peforms the action
                useranswers[count][0] = groupOptions.getSelection().getActionCommand();
            }
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);

        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupOptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupOptions.getSelection().getActionCommand();// getactioncommand peforms the
                                                                                       // action
            }
            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1]))// string comparison the actual answer ans the answer that user has marked.
                    score += 10;
                else
                    score += 0;
            }
            setVisible(false);
            new Score(name, score);
        }
    }

    public void paint(Graphics g) {//paint method is used which take the object of the graphics class as an argument
        super.paint(g);// we are calling the paint method in the super class  and passing graphics class onject that is g
        String time = "Time left - " + timer + " seconds ";//graphics
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        if (timer > 0) {//paint method calls by itself we do not have tto call it separatly
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }
        timer--;
        try {
            Thread.sleep(1000); // 1 thousand=1000millisecond we have to stop the timer for 1 sec for this we have used thread class sleep method,thread.sleep( method to pause the execution of the curreent thread)
            repaint();
            //thread.sleep( can throw interruptedException,if the thread is interrupted while it is sleeping)
            //after the thread is paused for 1 sec the repaint() method is caeed thid method is likely part of a gui framework such as swung of javaFX and is used to request the the gui component should be redrawn
        } catch (Exception e) {
            e.printStackTrace();//if the exception occurs within the try blCK THIS LINE PRINTS THE information about the exception to the console.it is using the printStacktrace() method of the Exception  object e to print the stack trace which included information about where the
            // exception occured and what caused it
        }//so the try-catch block is sued here to ensure that if an exception occures during the call to thread.sleep() the program does not crash abruptly and instead it can handle the exception appropriately such as printing a stack trace
//The throw keyword is used to explicitly 
//throw an exception from within a method or block of code. However, in the provided code snippet, there is no explicit need to throw an exception because the Thread.sleep(1000) method itself already throws an exception (InterruptedException) if the sleeping thread is interrupted.
        if (ans_given == 1) {//if and is given then set flag to 0
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) // auto submit if user dont click the sumbit button
            {
                if (groupOptions.getSelection() == null) {
                    useranswers[count][0] = "";//if no answer is given by user then store empty value
                } else {
                    useranswers[count][0] = groupOptions.getSelection().getActionCommand();// getactioncommand peforms
                                                                                           // the action whatever option the user has choosen will stored in useranswer array
                }
                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1]))// string comparison the actul answer ans the anaswer
                                                                // tht user has marked.

                        score += 10;
                    else
                        score += 0;
                }
                setVisible(false);//current frame will get invisible and the new score class frame will get open 

                new Score(name, score);//calling of score class
            } else {
                if (groupOptions.getSelection() == null) {
                    useranswers[count][0] = "";
                }

                else {

                    if (groupOptions.getSelection() == null) {
                        useranswers[count][0] = "";
                    } else {
                        useranswers[count][0] = groupOptions.getSelection().getActionCommand();// getactioncommand
                                                                                               // peforms the action
                    }

                    count++;
                    start(count);
                }
            }
        }
    }

    public void start(int count) {
        qno.setText((count + 1) + ". ");//this line of code sets the text of the qno object to a string that represent a numbered list .
        question.setText(questions[count][0]);//pick the value from first row and first column
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);// set the option with question
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        groupOptions.clearSelection();//suppose we have selected one option then after switching to the next option that option will be deselected 
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}
