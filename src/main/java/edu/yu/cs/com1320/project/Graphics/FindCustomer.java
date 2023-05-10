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
import java.util.Hashtable;

public class FindCustomer implements ActionListener {
    JFrame frame;
    static JTextField name;
    static JTextField address;
    static JTextField phoneNumber;

    // JFrame

    // JButton
    JButton mainMenu;

    static JButton b;
    Shop shop;

    static Hashtable<String, Car> CarHashtable = new Hashtable<>();

    // label to display text

    // default constructor
    public FindCustomer(JFrame tmpFrame,Shop shop) {
        frame = tmpFrame;

        frame.setLayout(new FlowLayout());

        this.shop = shop;

        paintGUI();
    }
    private void paintGUI(){
        b = new JButton("search");
        mainMenu = new JButton("Main Menu");
        mainMenu.addActionListener(this);
        mainMenu.setBounds(500,0,200,30);
        // addActionListener to button
        b.addActionListener(this);
        b.setBounds(300,0,200,30);

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
        frame.getContentPane().add(b);
        frame.getContentPane().add(mainMenu);

    }
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("search")) {
            // set the text of the label to the text of the field

            int phoneNumberInt = 0;
            if(!phoneNumber.getText().isEmpty()){
                phoneNumberInt= Integer.parseInt(phoneNumber.getText());
            }
            Customer tmpCustomer = new Customer(name.getText(),address.getText(),phoneNumberInt);
            int index= shop.getCustomers().indexOf(tmpCustomer);

            if(index>-1) {
                Customer customer = shop.getCustomers().get(index);

                frame.getContentPane().removeAll();
                frame.getContentPane().repaint();
                ModifyCustomer modifyCustomer = new ModifyCustomer(frame, shop, customer);
            }
            else{
                paintGUI();
            }

        }
        else if(s.equals("Main Menu")){
            frame.getContentPane().removeAll();
            MainWindow main = new MainWindow(frame,shop);
        }
    }
}
