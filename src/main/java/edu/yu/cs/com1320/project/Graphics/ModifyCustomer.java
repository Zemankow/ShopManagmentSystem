package edu.yu.cs.com1320.project.Graphics;

import edu.yu.cs.com1320.project.Car;
import edu.yu.cs.com1320.project.Customer;
import edu.yu.cs.com1320.project.MaintenanceJob;
import edu.yu.cs.com1320.project.Shop;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.Hashtable;

public class ModifyCustomer  implements ActionListener {

    JFrame frame;
    JButton remove;
    JButton modify;

    JButton mainMenu;

    JButton addMaintenance;

    Customer customer;

    static JTextField name;
    static JTextField address;
    static JTextField phoneNumber;

    Shop shop;
    Car carSelected;


    Hashtable<String, Car> carHashtable = new Hashtable<>();

    public ModifyCustomer(JFrame tmpFrame, Shop shop, Customer customer) {
        this.shop = shop;
        this.customer = customer;
        this.frame = tmpFrame;
        paintGUI();

    }

    private void paintGUI(){
        remove = new JButton("Remove");
        mainMenu = new JButton("Main Menu");
        modify = new JButton("Modify");
        addMaintenance = new JButton("Add Maintenance");

        addMaintenance.addActionListener(this);

        modify.addActionListener(this);

        for(Car car: customer.getCars()){
            carHashtable.put(car.toString(),car);
        }
        JComboBox maintanceCurrent = new JComboBox(carHashtable.keySet().toArray());
        maintanceCurrent.addActionListener(this);
        remove.addActionListener(this);
        mainMenu.addActionListener(this);



        name = new JTextField(16);
        name.setText(customer.getName());
        name.setBounds(100,0,200,30);
        address = new JTextField(16);

        address.setBounds(100,30,200,30);
        address.setText(customer.getAddress());

        NumberFormat format = NumberFormat.getInstance();
        format.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        // If you want the value to be committed on each keystroke instead of focus lost
        formatter.setCommitsOnValidEdit(true);
        phoneNumber = new JFormattedTextField(formatter);
        phoneNumber.setText(String.valueOf(customer.getPhoneNumber()));
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
        //Set up the picture.
        frame.getContentPane().setFont(frame.getContentPane().getFont().deriveFont(Font.ITALIC));

        //The preferred size is hard-coded to be the width of the
        //widest image and the height of the tallest image + the border.
        //A real program would compute this.


        //Lay out the demo.

        frame.getContentPane().add(maintanceCurrent, BorderLayout.PAGE_START);
        frame.getContentPane().add(remove);
        frame.getContentPane().add(mainMenu);
        frame.getContentPane().add(modify);
        frame.getContentPane().add(addMaintenance);
        frame.getContentPane().repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object object = e.getSource();
        if(object instanceof JComboBox){
            JComboBox combo = (JComboBox)object;
            String maintananceJob = (String)combo.getSelectedItem();
            carSelected = carHashtable.get(maintananceJob);
        }
        if(object instanceof JButton) {
            JButton button = (JButton)object;
            String s = button.getActionCommand();
            if (s.equals("Remove")) {

                frame.getContentPane().removeAll();
                if(carSelected!=null) {
                    carHashtable.remove(carSelected.toString());
                    customer.removeCar(carSelected);
                }
                paintGUI();


            }
            else if(s.equals("Modify")){
                customer.setName(name.toString());
                customer.setAddress(address.toString());
                if(!phoneNumber.getText().isEmpty()){
                    customer.setPhoneNumber(Integer.parseInt(phoneNumber.getText()));
                }
                frame.getContentPane().removeAll();
                paintGUI();

            }
            else if(s.equals("Main Menu")){
                frame.getContentPane().removeAll();
                MainWindow main = new MainWindow(frame,shop);
            }
            else if(s.equals("Add Maintenance")){
                frame.getContentPane().removeAll();
                AddMaintenance maintenance = new AddMaintenance(frame,shop,customer,carSelected);
            }
        }
    }
}
