package edu.yu.cs.com1320.project.Graphics;

// Java program to create a blank text
// field of definite number of columns.
import edu.yu.cs.com1320.project.Customer;
import edu.yu.cs.com1320.project.Shop;

import java.awt.event.*;
import java.text.Format;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.text.NumberFormatter;

public class AddCustomer implements ActionListener {
    // JTextField

    JFrame frame;
    static JTextField name;
    static JTextField address;
    static JTextField phoneNumber;

    // JFrame

    // JButton
    static JButton b;
    Shop shop;

    // label to display text

    // default constructor
    public AddCustomer(JFrame tmpFrame,Shop shop)
    {
        frame = tmpFrame;
        b = new JButton("submit");

        this.shop = shop;

        // addActionListener to button
        b.addActionListener(this);
        b.setBounds(200,0,200,30);

        name = new JTextField(16);
        name.setBounds(0,0,200,30);
        address = new JTextField(16);

        address.setBounds(0,30,200,30);

        NumberFormat format = NumberFormat.getInstance();
        format.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        // If you want the value to be committed on each keystroke instead of focus lost
        formatter.setCommitsOnValidEdit(true);
        phoneNumber = new JFormattedTextField(formatter);
        phoneNumber.setBounds(0,60,200,30);

        phoneNumber.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = phoneNumber.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    phoneNumber.setEditable(true);
                    phoneNumber.setText("");
                } else {
                    phoneNumber.setEditable(false);
                    phoneNumber.setText("* Enter only numeric digits(0-9)");
                }
            }
        });
        frame.getContentPane().add(name);
        frame.getContentPane().add(address);
        frame.getContentPane().add(phoneNumber);

        frame.getContentPane().add(b);
        frame.getContentPane().repaint();
    }


    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("submit")) {

            // set the text of the label to the text of the field

            Customer customer = new Customer(name.getText(),address.getText(),Integer.parseInt(phoneNumber.getText()));
            shop.addCustomer(customer);
            frame.getContentPane().removeAll();
            frame.getContentPane().repaint();
            MainWindow mainWindow = new MainWindow(frame,shop);



        }
    }
}