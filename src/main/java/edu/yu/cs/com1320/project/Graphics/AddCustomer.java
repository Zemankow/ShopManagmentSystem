package edu.yu.cs.com1320.project.Graphics;

// Java program to create a blank text
// field of definite number of columns.
import edu.yu.cs.com1320.project.Car;
import edu.yu.cs.com1320.project.Customer;
import edu.yu.cs.com1320.project.Shop;

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.text.NumberFormatter;

public class AddCustomer implements ActionListener {
    // JTextField
    JFrame frame;
    static JTextField name;
    static JTextField address;
    static JTextField phoneNumber;

    JTextField vin;
    JTextField model;
    JTextField make;
    JTextField odometer;
    // JFrame

    // JButton
    static JButton submit;

    static JButton mainMenu;

    Shop shop;


    // label to display text

    // default constructor
    public AddCustomer(JFrame tmpFrame,Shop shop)
    {
        frame = tmpFrame;
        submit = new JButton("submit");
        frame.setLayout(new FlowLayout());

        this.shop = shop;
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
        odometer = new JFormattedTextField(formatter);
        odometer.setBounds(100,220,200,30);
        odometer.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = odometer.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')) {
                    odometer.setEditable(true);
                    odometer.setText("");
                } else {
                    odometer.setEditable(false);
                    odometer.setText("* Enter only numeric digits(0-9)");
                }
            }
        });

        vin = new JTextField(16);
        vin.setBounds(100,130,200,30);

        make = new JTextField(16);
        make.setBounds(100,160,200,30);
        model = new JTextField(16);
        model.setBounds(100,190,200,30);

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
        JLabel addCarLabel = new JLabel("Add Car");
        addCarLabel.setBounds(0,100,100,30);
        frame.getContentPane().add(addCarLabel);
        JLabel carVim = new JLabel("Vin:");
        carVim.setBounds(0,130,100,30);
        frame.getContentPane().add(carVim);
        frame.getContentPane().add(vin);
        JLabel carMake = new JLabel("Make:");
        carMake.setBounds(0,160,100,30);
        frame.getContentPane().add(carMake);
        frame.getContentPane().add(make);


        JLabel carModel = new JLabel("Model:");
        carModel.setBounds(0,190,100,30);
        frame.getContentPane().add(carModel);
        frame.getContentPane().add(model);
        JLabel carOdometer = new JLabel("Odometer:");
        carOdometer.setBounds(0,220,100,30);
        frame.getContentPane().add(carOdometer);
        frame.getContentPane().add(odometer);
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
            Customer customer = new Customer(name.getText(),address.getText(),phoneNumberInt);
            int odometerInt = 0;
            if(!odometer.getText().isEmpty()){
                odometerInt= Integer.parseInt(odometer.getText());
            }
            Car car = new Car(vin.getText(),make.getText(),model.getText(), LocalDate.now(),odometerInt);
            if(car.isComplete()){
                customer.addCar(car);
            }
            shop.addCustomer(customer);
            frame.getContentPane().removeAll();
            frame.getContentPane().repaint();
            MainWindow mainWindow = new MainWindow(frame,shop);


        }
        else if(s.equals("Main Menu")){
            frame.getContentPane().removeAll();
            MainWindow main = new MainWindow(frame,shop);
        }
    }
}