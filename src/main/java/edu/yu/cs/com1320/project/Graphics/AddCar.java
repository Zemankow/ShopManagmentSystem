package edu.yu.cs.com1320.project.Graphics;

import edu.yu.cs.com1320.project.Car;
import edu.yu.cs.com1320.project.Customer;
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

public class AddCar implements ActionListener {
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
    Customer customer;


    // label to display text

    // default constructor
    public AddCar(JFrame tmpFrame, Shop shop, Customer customer) {
        frame = tmpFrame;
        submit = new JButton("submit");
        frame.setLayout(new FlowLayout());
        this.customer = customer;

        this.shop = shop;
        paintGUI();


    }

    private void paintGUI() {
        mainMenu = new JButton("Main Menu");

        mainMenu.addActionListener(this);
        mainMenu.setBounds(500, 0, 200, 30);
        // addActionListener to button
        submit.addActionListener(this);
        submit.setBounds(300, 0, 200, 30);

        name = new JTextField(16);
        name.setBounds(100, 0, 200, 30);
        address = new JTextField(16);

        address.setBounds(100, 30, 200, 30);

        NumberFormat format = NumberFormat.getInstance();
        format.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        // If you want the value to be committed on each keystroke instead of focus lost
        formatter.setCommitsOnValidEdit(true);
        phoneNumber = new JFormattedTextField(formatter);
        phoneNumber.setBounds(100, 60, 200, 30);

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
        odometer.setBounds(100, 90, 200, 30);
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
        vin.setBounds(100, 0, 200, 30);

        make = new JTextField(16);
        make.setBounds(100, 30, 200, 30);
        model = new JTextField(16);
        model.setBounds(100, 60, 200, 30);


        JLabel carVim = new JLabel("Vin:");
        carVim.setBounds(0, 0, 100, 30);
        frame.getContentPane().add(carVim);
        frame.getContentPane().add(vin);
        JLabel carMake = new JLabel("Make:");
        carMake.setBounds(0, 30, 100, 30);
        frame.getContentPane().add(carMake);
        frame.getContentPane().add(make);


        JLabel carModel = new JLabel("Model:");
        carModel.setBounds(0, 60, 100, 30);
        frame.getContentPane().add(carModel);
        frame.getContentPane().add(model);
        JLabel carOdometer = new JLabel("Odometer:");
        carOdometer.setBounds(0, 90, 100, 30);
        frame.getContentPane().add(carOdometer);
        frame.getContentPane().add(odometer);
        frame.getContentPane().add(mainMenu);
        frame.getContentPane().add(submit);
        frame.getContentPane().repaint();
    }


    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("submit")) {
            // set the text of the label to the text of the field

            int odometerInt = 0;
            if (!odometer.getText().isEmpty()) {
                odometerInt = Integer.parseInt(odometer.getText());
            }
            Car car = new Car(vin.getText(), make.getText(), model.getText(), LocalDate.now(), odometerInt);
            if (car.isComplete()) {
                customer.addCar(car);
            }
            frame.getContentPane().removeAll();

            paintGUI();


        } else if (s.equals("Main Menu")) {
            frame.getContentPane().removeAll();
            MainWindow main = new MainWindow(frame, shop);
        }
    }
}
