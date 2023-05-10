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
    JButton findCustomer;
    JButton listCustomer;


    Shop shop;

    // label to display text

    // default constructor
    public MainWindow(JFrame tmpFrame,Shop tmpShop)
    {
        frame = tmpFrame;
        frame.setLayout(new GridLayout());


        addCustomerButton = new JButton("Add Customer");
        markMaintananceDone = new JButton("Mark Maintanance Done");
        findCustomer = new JButton("Find Customer");
        listCustomer = new JButton("List Customer");

        this.shop = tmpShop;

        // addActionListener to button
        addCustomerButton.setBounds(200,0,200,30);
        addCustomerButton.addActionListener(this);

        markMaintananceDone.setBounds(0,0,200,30);
        markMaintananceDone.addActionListener(this);
        findCustomer.setBounds(400,0,200,30);
        findCustomer.addActionListener(this);
        listCustomer.setBounds(600,0,200,30);
        listCustomer.addActionListener(this);
        // create a panel to add buttons and textfield
        frame.getContentPane().add(addCustomerButton);
        frame.getContentPane().add(markMaintananceDone);
        frame.getContentPane().add(findCustomer);
        frame.getContentPane().add(listCustomer);


        frame.getContentPane().repaint();


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
        else if(s.equals("Find Customer")){
            frame.getContentPane().removeAll();
            frame.getContentPane().repaint();
            FindCustomer findCustomer = new FindCustomer(frame,shop);
        }
        else if(s.equals("List Customer")){
            frame.getContentPane().removeAll();
            frame.getContentPane().repaint();
            ListCustomers listCustomers = new ListCustomers(frame,shop);
        }

    }
}