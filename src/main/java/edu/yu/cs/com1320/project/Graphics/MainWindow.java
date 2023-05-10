package edu.yu.cs.com1320.project.Graphics;

import edu.yu.cs.com1320.project.Car;
import edu.yu.cs.com1320.project.Customer;
import edu.yu.cs.com1320.project.MaintenanceJob;
import edu.yu.cs.com1320.project.Shop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class MainWindow implements ActionListener {
    // JTextField

    JFrame frame;

    // JFrame

    // JButton
    JButton addCustomerButton;
    JButton markMaintananceDone;

    Shop shop;

    // label to display text

    // default constructor
    public MainWindow(JFrame tmpFrame,Shop shop)
    {
        frame = tmpFrame;
        frame.setLayout(new GridLayout());


        addCustomerButton = new JButton("Add Customer");
        markMaintananceDone = new JButton("Mark Maintanance Done");

        this.shop = shop;

        // addActionListener to button
        addCustomerButton.setBounds(200,0,200,30);
        addCustomerButton.addActionListener(this);

        markMaintananceDone.setBounds(0,0,200,30);
        markMaintananceDone.addActionListener(this);

        // create a panel to add buttons and textfield
        frame.getContentPane().add(addCustomerButton);
        frame.getContentPane().add(markMaintananceDone);


        frame.getContentPane().repaint();
        Car car = new Car("1","Toyota", "2019", LocalDate.now(),10000);
        car.addCurrentMaintenance(new MaintenanceJob(200000, MaintenanceJob.MaintenanceType.AC,"Ac is not working properly"));
        shop.addCar(car);
        shop.moveCarToBay();

    }


    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("Add Customer")) {

            frame.getContentPane().removeAll();
            frame.getContentPane().repaint();
            AddCustomer addCustomer = new AddCustomer(frame,shop);

        }
        else if(s.equals("Mark Maintanance Done")){
            frame.getContentPane().removeAll();
            frame.getContentPane().repaint();
            SelectCarMaintanance selectCarMaintanance = new SelectCarMaintanance(frame,shop);
        }


    }
}