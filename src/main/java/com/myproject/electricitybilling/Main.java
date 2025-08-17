
package com.myproject.electricitybilling;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Main extends JFrame implements ActionListener{
    Main(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon img = new ImageIcon(getClass().getResource("/electricity-image.jpg"));
        Image i2 = img.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        
        JMenu master = new JMenu("Electricity Bill Payment");
        mb.add(master);
        
        JMenuItem login = new JMenuItem("Login");
        master.add(login);
        login.addActionListener(this);
        
         JMenuItem account = new JMenuItem("Create Account");
        master.add(account);
                account.addActionListener(this);

        
         JMenuItem newCustomer = new JMenuItem("Payment System");
        master.add(newCustomer);
                newCustomer.addActionListener(this);

        
        setLayout(new FlowLayout());
        
        
    }
    public static void main(String[] args) {
         Main frame = new Main();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        if(msg.equals("Login")){
//            setVisible(false);
            loginFrame frame = new loginFrame();
            frame.setVisible(true);
        }
    }
 
}
