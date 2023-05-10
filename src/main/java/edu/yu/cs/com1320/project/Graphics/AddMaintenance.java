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


public class AddMaintenance implements ActionListener {
    JFrame frame;
    Car car;

    Customer customer;
    Shop shop;

    JButton add;
    JButton back;
    JTextField odometer;
    JTextField complaint;


    MaintenanceJob.MaintenanceType type;
    public AddMaintenance(JFrame tmpFrame, Shop shop, Customer customer, Car car) {

        frame = tmpFrame;

        this.customer = customer;
        this.shop = shop;
        this.car = car;
        frame.getContentPane().repaint();
        paintGUI();
    }

    private void paintGUI(){
        add = new JButton("Add");
        back = new JButton("Back");



        back.addActionListener(this);
        back.setBounds(500,0,200,30);
        // addActionListener to button
        add.addActionListener(this);
        add.setBounds(300,0,200,30);
        complaint = new JTextField(50);
        complaint.setBounds(500,0,200,100);
        NumberFormat format = NumberFormat.getInstance();
        format.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        // If you want the value to be committed on each keystroke instead of focus lost
        formatter.setCommitsOnValidEdit(true);


        odometer = new JFormattedTextField(formatter);
        odometer.setBounds(100,60,200,30);
        odometer.setColumns(16);

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

        JLabel carOdometer = new JLabel("Odometer:");
        carOdometer.setBounds(0,00,100,30);
        frame.getContentPane().add(carOdometer);
        frame.getContentPane().add(odometer);

        JComboBox maintenanceTypes = new JComboBox(MaintenanceJob.MaintenanceType.values());
        maintenanceTypes.setBounds(0,0,100,30);

        maintenanceTypes.addActionListener(this);
        frame.getContentPane().setFont(frame.getContentPane().getFont().deriveFont(Font.ITALIC));

        frame.getContentPane().add(maintenanceTypes, BorderLayout.PAGE_START);
        frame.getContentPane().add(add);
        frame.getContentPane().add(back);
        frame.getContentPane().add(complaint);

        frame.getContentPane().repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        Object object = e.getSource();

        if(object instanceof JComboBox){
            JComboBox<MaintenanceJob.MaintenanceType> combo = (JComboBox<MaintenanceJob.MaintenanceType>)object;
            Object objectItem = combo.getSelectedItem();
            type = (MaintenanceJob.MaintenanceType)objectItem;
        }
        else if (s.equals("Add")) {
            // set the text of the label to the text of the field

            int odometerInt = 0;
            if(!odometer.getText().isEmpty()){
                odometerInt= Integer.parseInt(odometer.getText());
            }
            if(type!=null) {
                MaintenanceJob maintenanceJob = new MaintenanceJob(odometerInt, type, complaint.getText());
                car.addMaintenanceJob(maintenanceJob);
                frame.getContentPane().removeAll();
                frame.getContentPane().repaint();
                paintGUI();
            }

        }
        else if(s.equals("Back")){
            frame.getContentPane().removeAll();

            shop.addCar(car);
            ModifyCustomer modifyCustomer = new ModifyCustomer(frame,shop,customer);
        }

    }


}
