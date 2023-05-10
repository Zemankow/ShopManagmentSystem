package edu.yu.cs.com1320.project.Graphics;

import edu.yu.cs.com1320.project.Car;
import edu.yu.cs.com1320.project.Customer;
import edu.yu.cs.com1320.project.MaintenanceJob;
import edu.yu.cs.com1320.project.Shop;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

public class AddMaintenance implements ActionListener {
    JFrame frame;
    Car car;

    JButton add;
    JButton back;
    JTextField odometer;
    JTextField complaint;


    MaintenanceJob.MaintenanceType type;
    public AddMaintenance(JFrame tmpFrame, Car car) {

        frame = tmpFrame;

        frame.setLayout(new FlowLayout());

        this.car = car;

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

        JLabel carOdometer = new JLabel("Odometer:");
        carOdometer.setBounds(0,220,100,30);
        frame.getContentPane().add(carOdometer);
        frame.getContentPane().add(odometer);

        JComboBox maintenanceTypes = new JComboBox(MaintenanceJob.MaintenanceType.values());
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
            type = combo.getSelectedItem();
        }
        else if (s.equals("Add")) {
            // set the text of the label to the text of the field

            int odometerInt = 0;
            if(!odometer.getText().isEmpty()){
                odometerInt= Integer.parseInt(odometer.getText());
            }
            if(type!=null) {
                MaintenanceJob maintenanceJob = new MaintenanceJob(odometerInt, type, );
                car.addMaintenanceJob(maintenanceJob);
            }

        }
        else if(s.equals("Main Menu")){
            frame.getContentPane().removeAll();
            MainWindow main = new MainWindow(frame,shop);
        }

    }


}
