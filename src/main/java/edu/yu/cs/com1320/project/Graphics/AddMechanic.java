package edu.yu.cs.com1320.project.Graphics;

import edu.yu.cs.com1320.project.Car;
import edu.yu.cs.com1320.project.Customer;
import edu.yu.cs.com1320.project.Mechanic;
import edu.yu.cs.com1320.project.Shop;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.time.LocalDate;

public class AddMechanic implements ActionListener {
    JFrame frame;
    static JTextField name;
    static JTextField address;
    static JTextField phoneNumber;


    // JButton
    static JButton submit;

    static JButton mainMenu;

    Shop shop;


    // label to display text

    // default constructor
    public AddMechanic(JFrame tmpFrame,Shop shop)
    {
        frame = tmpFrame;
        frame.setLayout(new FlowLayout());

        this.shop = shop;
        paintGUI();
    }

    private void paintGUI(){
        submit = new JButton("submit");

        mainMenu = new JButton("Main Menu");

        mainMenu.addActionListener(this);
        mainMenu.setBounds(500,0,200,30);
        // addActionListener to button
        submit.addActionListener(this);
        submit.setBounds(300,0,200,30);

        name = new JTextField(16);
        name.setBounds(100,0,200,30);
        address = new JTextField(16);

        address.setBounds(100,30,200,30);

        NumberFormat format = NumberFormat.getInstance();
        format.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        // If you want the value to be committed on each keystroke instead of focus lost
        formatter.setCommitsOnValidEdit(true);
        phoneNumber = new JFormattedTextField(formatter);
        phoneNumber.setBounds(100,60,200,30);

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


        // If you want the value to be committed on each keystroke instead of focus lost


        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(0,0,100,30);
        frame.getContentPane().add(nameLabel);
        frame.getContentPane().add(name);
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(0,30,100,30);
        frame.getContentPane().add(addressLabel);

        frame.getContentPane().add(address);
        JLabel phoneNumberLabel = new JLabel("PhoneNumber:");
        phoneNumberLabel.setBounds(0,60,100,30);
        frame.getContentPane().add(phoneNumberLabel);
        frame.getContentPane().add(phoneNumber);


        frame.getContentPane().add(mainMenu);
        frame.getContentPane().add(submit);
        frame.getContentPane().repaint();
    }


    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("submit")) {
            // set the text of the label to the text of the field
            int phoneNumberInt = 0;
            if(!phoneNumber.getText().isEmpty()){
                phoneNumberInt= Integer.parseInt(phoneNumber.getText());
            }
            Mechanic mechanic = new Mechanic(name.getText(),address.getText(),phoneNumberInt,LocalDate.now());
            shop.addMechanic(mechanic);
            frame.getContentPane().removeAll();
            frame.getContentPane().repaint();
            paintGUI();
        }
        else if(s.equals("Main Menu")){
            frame.getContentPane().removeAll();
            MainWindow main = new MainWindow(frame,shop);
        }
    }

}
