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

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class electricity extends JFrame implements ActionListener {

    private Container c;
    private JLabel userLabel, name, passLabel, create, meter;
    private Font f;
    private JButton createButton, backButton;
    private JTextField tf, tn, mn;
    private JPasswordField pf;
    private JComboBox cb;

    electricity() {
//        initComponents();
//    }
//
//    public void initComponents() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(500, 200, 500, 350);
        this.setTitle("Create Account");

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);

        f = new Font("Arial", Font.BOLD, 12);

        create = new JLabel("Create Account As : ");
        create.setBounds(50, 50, 150, 20);
        create.setFont(f);
        c.add(create);

        cb = new JComboBox();
        cb.setBounds(200, 50, 200, 20);
        cb.addItem("Admin");
        cb.addItem("Customer");
        c.add(cb);

        meter = new JLabel("Meter Number : ");
        meter.setBounds(50, 90, 150, 20);
        meter.setFont(f);
        c.add(meter);

        mn = new JTextField();
        mn.setFont(f);
        mn.setBounds(200, 90, 200, 20);
        c.add(mn);

        userLabel = new JLabel("Username : ");
        userLabel.setBounds(50, 120, 150, 20);
        userLabel.setFont(f);
        c.add(userLabel);

        tf = new JTextField();
        tf.setFont(f);
        tf.setBounds(200, 120, 200, 20);
        c.add(tf);

        name = new JLabel("Name : ");
        name.setBounds(50, 150, 150, 20);
        name.setFont(f);
        c.add(name);

        tn = new JTextField();
        tn.setFont(f);
        tn.setBounds(200, 150, 200, 20);
        c.add(tn);

        passLabel = new JLabel("Password : ");
        passLabel.setBounds(50, 180, 150, 20);
        passLabel.setFont(f);
        c.add(passLabel);

        pf = new JPasswordField();
        pf.setFont(f);
        pf.setBounds(200, 180, 200, 20);
        pf.setEchoChar('*');
        c.add(pf);

        createButton = new JButton("Create");
        createButton.setBounds(100, 230, 120, 20);
        createButton.setFont(f);
        createButton.setBackground(Color.black);
        createButton.setForeground(Color.WHITE);
        c.add(createButton);

        backButton = new JButton("Back");
        backButton.setBounds(230, 230, 120, 20);
        backButton.setFont(f);
        backButton.setBackground(Color.black);
        backButton.setForeground(Color.WHITE);
        c.add(backButton);
        
        createButton.addActionListener(this);
        backButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == createButton){
             String userName = tf.getText();
            String password = pf.getText();  
            String select;
            select = (String) cb.getSelectedItem();
            if(select.equals("Admin") && userName.equals("admin") && password.equals("123")){
                setVisible(false);
                 newCustomer frame = new newCustomer();
                frame.setVisible(true);
            } 
            else if(select.equals("Customer") && userName.equals("user") && password.equals("1234")){
                setVisible(false);
                 newCustomer frame = new newCustomer();
                frame.setVisible(true);                
            } else{
               JOptionPane.showMessageDialog(null, "Wrong userName and Password");
               tf.setText("");
               pf.setText("");
            }
            
            
        }
        else if(e.getSource()== backButton){
            setVisible(false);
            loginFrame frame = new loginFrame();
            frame.setVisible(true);
        }
         else{
               JOptionPane.showMessageDialog(null, "Please create account.");
            }

    }

    public static void main(String[] args) {
        electricity frame = new electricity();
        frame.setVisible(true);
    }

}
