package edu.yu.cs.com1320.project.Graphics;

import edu.yu.cs.com1320.project.Customer;
import edu.yu.cs.com1320.project.MaintenanceJob;
import edu.yu.cs.com1320.project.Shop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Currency;
import java.util.Hashtable;

public class ListCustomers implements ActionListener {

    static JFrame frame;


    // JButton
    static JButton mainMenu;

    static JButton b;
    Shop shop;

    static Hashtable<String, Customer> customerHashtable = new Hashtable<>();


    Customer customerSelected;
    public ListCustomers(JFrame tmpFrame, Shop shop) {

        frame = tmpFrame;

        frame.setLayout(new FlowLayout());

        this.shop = shop;

        paintGUI();
    }
    private void paintGUI(){
        b = new JButton("Modify");
        mainMenu = new JButton("Main Menu");



        mainMenu.addActionListener(this);
        mainMenu.setBounds(500,0,200,30);
        // addActionListener to button
        b.addActionListener(this);
        b.setBounds(300,0,200,30);

        for(Customer customer: shop.getCustomers()){
            customerHashtable.put(customer.toString(),customer);
        }
        JComboBox customers = new JComboBox(customerHashtable.keySet().toArray());
        customers.addActionListener(this);
        frame.getContentPane().setFont(frame.getContentPane().getFont().deriveFont(Font.ITALIC));

        frame.getContentPane().add(customers, BorderLayout.PAGE_START);
        frame.getContentPane().add(b);
        frame.getContentPane().add(mainMenu);

        frame.getContentPane().repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object object = e.getSource();
        if(object instanceof JComboBox){
            JComboBox combo = (JComboBox)object;
            String maintananceJob = (String)combo.getSelectedItem();
            customerSelected = customerHashtable.get(maintananceJob);
        }
        if(object instanceof JButton) {
            JButton button = (JButton)object;
            String s = button.getActionCommand();
            if (s.equals("Modify")) {

                frame.getContentPane().removeAll();
                frame.getContentPane().repaint();
                if(customerSelected!=null) {
                    ModifyCustomer modifyCustomer = new ModifyCustomer(frame,shop,customerSelected);
                }
                else {
                    paintGUI();
                }

            }
            else if(s.equals("Main Menu")){
                frame.getContentPane().removeAll();
                MainWindow main = new MainWindow(frame,shop);
            }
        }
    }
}
