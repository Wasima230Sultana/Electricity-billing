package com.myproject.electricitybilling;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginFrame extends JFrame implements ActionListener {

    private JLabel userLabel, passLabel, logging;
    private JTextField tf;
    private JPasswordField pf;
    private JButton loginButton, signup, cancelbtn;
    private Container c;
    private Font f;
    private JComboBox cb;

    loginFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500, 200, 450, 320);
        this.setTitle("Login Page");

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);

        f = new Font("Arial", Font.BOLD, 12);

        userLabel = new JLabel("Username : ");
        userLabel.setBounds(50, 50, 150, 20);
        userLabel.setFont(f);
        c.add(userLabel);

        tf = new JTextField();
        tf.setFont(f);
        tf.setBounds(170, 50, 200, 20);
        c.add(tf);

        passLabel = new JLabel("Password : ");
        passLabel.setBounds(50, 80, 150, 20);
        passLabel.setFont(f);
        c.add(passLabel);

        pf = new JPasswordField();
        pf.setFont(f);
        pf.setBounds(170, 80, 200, 20);
        pf.setEchoChar('*');
        c.add(pf);

        logging = new JLabel("Logging in as : ");
        logging.setBounds(50, 110, 150, 20);
        logging.setFont(f);
        c.add(logging);

        cb = new JComboBox();
        cb.setBounds(170, 110, 200, 20);
        cb.addItem("Admin");
        cb.addItem("Customer");
        c.add(cb);

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 190, 90, 20);
        loginButton.setFont(f);
        c.add(loginButton);

        cancelbtn = new JButton("Cancel");
        cancelbtn.setBounds(210, 190, 90, 20);
        cancelbtn.setFont(f);
        c.add(cancelbtn);

//        signup = new JButton("Signup");
//        signup.setBounds(150, 220, 90, 20);
//        signup.setFont(f);
//        c.add(signup);

        loginButton.addActionListener(this);
        cancelbtn.addActionListener(this);
//        signup.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userName = tf.getText();
            String password = pf.getText();  
            String select;
            select = (String) cb.getSelectedItem();
            if(select.equals("Admin") && userName.equals("admin") && password.equals("123")){
                setVisible(false);
                electricity frame = new electricity();
                frame.setVisible(true);
                
            } 
            else if(select.equals("Customer") && userName.equals("user") && password.equals("1234")){
                setVisible(false);
                electricity frame = new electricity();
                frame.setVisible(true);
                
            } 
            else{
               JOptionPane.showMessageDialog(null, "Wrong userName and Password");
               tf.setText("");
               pf.setText("");
            }
        } else if (e.getSource() == cancelbtn) {
            setVisible(false);
        } 
//else if (e.getSource() == signup) {
//            setVisible(false);
//           electricity frame =  new electricity();
//           frame.setVisible(true);
//        }

    }

    public static void main(String[] args) {
        loginFrame frame = new loginFrame();
        frame.setVisible(true);
    }

}
