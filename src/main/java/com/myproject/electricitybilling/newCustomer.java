package com.myproject.electricitybilling;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class newCustomer extends JFrame implements ActionListener {

    private JLabel address, unit, month;
    private JTextField tfAddress, tfUnits;
    private JButton submitButton, cancelButton;
    private JComboBox<String> cbMonth;
    private String[] months = {
        "January", "February", "March", "April", "May", "June", "July", 
        "August", "September", "October", "November", "December"
    };
    private Container c;
    private Font f;

    newCustomer() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500, 200, 450, 300);
        this.setTitle("New Customer");

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);

        f = new Font("Arial", Font.BOLD, 12);

        // Address
        address = new JLabel("Address");
        address.setBounds(50, 50, 150, 20);
        address.setFont(f);
        c.add(address);

        tfAddress = new JTextField();
        tfAddress.setFont(f);
        tfAddress.setBounds(200, 50, 200, 20);
        c.add(tfAddress);

        // Units
        unit = new JLabel("Units consumed");
        unit.setBounds(50, 80, 150, 20);        
        unit.setFont(f);
        c.add(unit);

        tfUnits = new JTextField();
        tfUnits.setFont(f);
        tfUnits.setBounds(200, 80, 200, 20);
        c.add(tfUnits);

        // Month
        month = new JLabel("Month");
        month.setBounds(50, 110, 150, 20);
        month.setFont(f);
        c.add(month);

        cbMonth = new JComboBox<>(months);
        cbMonth.setBounds(200, 110, 200, 20);
        c.add(cbMonth);

        // Buttons
        submitButton = new JButton("Submit");
        submitButton.setBounds(100, 160, 120, 30);
        submitButton.setFont(f);
        submitButton.setBackground(Color.black);
        submitButton.setForeground(Color.WHITE);
        c.add(submitButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(230, 160, 120, 30);
        cancelButton.setFont(f);
        cancelButton.setBackground(Color.black);
        cancelButton.setForeground(Color.WHITE);
        c.add(cancelButton);

        submitButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submitButton){
            try {
                float units = Float.parseFloat(tfUnits.getText());
                float totalCost = units * 7.20f;
                JOptionPane.showMessageDialog(
                    null,
                    "Address: " + tfAddress.getText() + 
                    "\nMonth: " + cbMonth.getSelectedItem() +
                    "\nTotal Cost: " + totalCost,
                    "Electricity Bill",
                    JOptionPane.INFORMATION_MESSAGE
                );
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number for units.");
            }
        } else if(e.getSource() == cancelButton){
            tfAddress.setText("");
            tfUnits.setText("");
        }
    }

    public static void main(String[] args) {
        newCustomer frame = new newCustomer();
        frame.setVisible(true);
    }
}
