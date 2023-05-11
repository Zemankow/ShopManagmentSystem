package edu.yu.cs.com1320.project.Graphics;


import edu.yu.cs.com1320.project.Shop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class MainWindow implements ActionListener {
    // JTextField

    static JFrame frame;

    // JFrame

    // JButton
    static JButton addCustomerButton;
    static JButton addMechanicButton;

    static JButton markMaintananceDone;
    static JButton findCustomer;
    static JButton listCustomer;
    static JButton listMechanics;

    static JButton readyForPickup;


    Shop shop;

    // label to display text

    // default constructor
    public MainWindow(JFrame tmpFrame,Shop tmpShop)
    {
        frame = tmpFrame;
        frame.setLayout(new FlowLayout());


        addCustomerButton = new JButton("Add Customer");
        addMechanicButton = new JButton("Add Mechanic");

        markMaintananceDone = new JButton("Modify Maintenance");
        findCustomer = new JButton("Find Customer");
        listCustomer = new JButton("List Customer");
        listMechanics = new JButton("List Mechanics");

        readyForPickup = new JButton("Ready For Pickup");

        this.shop = tmpShop;

        // addActionListener to button
        addCustomerButton.setBounds(200,0,200,30);
        addCustomerButton.addActionListener(this);
        addMechanicButton.setBounds(1000,0,200,30);
        addMechanicButton.addActionListener(this);

        markMaintananceDone.setBounds(0,0,200,30);
        markMaintananceDone.addActionListener(this);
        findCustomer.setBounds(400,0,200,30);
        findCustomer.addActionListener(this);
        listCustomer.setBounds(600,0,200,30);
        listCustomer.addActionListener(this);
        listMechanics.setBounds(1200,0,200,30);
        listMechanics.addActionListener(this);

        readyForPickup.setBounds(800,0,200,30);
        readyForPickup.addActionListener(this);
        // create a panel to add buttons and textfield
        frame.getContentPane().add(addMechanicButton);
        frame.getContentPane().add(addCustomerButton);
        frame.getContentPane().add(markMaintananceDone);
        frame.getContentPane().add(findCustomer);
        frame.getContentPane().add(listCustomer);
        frame.getContentPane().add(listMechanics);

        frame.getContentPane().add(readyForPickup);


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
        else if (s.equals("Add Mechanic")) {

            frame.getContentPane().removeAll();
            frame.getContentPane().repaint();
            AddMechanic addMechanic = new AddMechanic(frame,shop);

        }
        else if(s.equals("Modify Maintenance")){
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
        else if(s.equals("List Mechanics")){
            frame.getContentPane().removeAll();
            frame.getContentPane().repaint();
            ListMechanics listCustomers = new ListMechanics(frame,shop);
        }
        else if(s.equals("Ready For Pickup")){
            frame.getContentPane().removeAll();
            frame.getContentPane().repaint();
            ReadyForPickup listCustomers = new ReadyForPickup(frame,shop);
        }

    }
}