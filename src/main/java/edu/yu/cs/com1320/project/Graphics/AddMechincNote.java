package edu.yu.cs.com1320.project.Graphics;

import edu.yu.cs.com1320.project.Customer;
import edu.yu.cs.com1320.project.MaintenanceJob;
import edu.yu.cs.com1320.project.Mechanic;
import edu.yu.cs.com1320.project.Shop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class AddMechincNote implements ActionListener {

    static JFrame frame;


    // JButton
    static JButton mainMenu;
    static MaintenanceJob maintenanceJob;
    static JTextField note;

    static JButton add;
    Shop shop;

    static Hashtable<String, Mechanic> mechanicHashtable = new Hashtable<>();


    static Mechanic mechanicSelected;
    public AddMechincNote(JFrame tmpFrame, Shop shop, MaintenanceJob maintenanceJob) {

        frame = tmpFrame;

        frame.setLayout(new FlowLayout());

        this.shop = shop;
        this.maintenanceJob = maintenanceJob;
        paintGUI();
    }
    private void paintGUI(){
        mainMenu = new JButton("Main Menu");
        add = new JButton("Add");

        add.addActionListener(this);
        add.setBounds(400,0,200,30);

        mainMenu.addActionListener(this);
        mainMenu.setBounds(200,0,200,30);

        note = new JTextField(16);
        note.setBounds(0,0,200,30);
        // addActionListener to button

        for(Mechanic mechanic: shop.getMechanics()){
            mechanicHashtable.put(mechanic.toString(),mechanic);
        }
        JComboBox customers = new JComboBox(mechanicHashtable.keySet().toArray());
        customers.addActionListener(this);
        frame.getContentPane().setFont(frame.getContentPane().getFont().deriveFont(Font.ITALIC));

        frame.getContentPane().add(customers, BorderLayout.PAGE_START);
        frame.getContentPane().add(mainMenu);
        frame.getContentPane().add(note);
        frame.getContentPane().add(add);

        frame.getContentPane().repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object object = e.getSource();
        if(object instanceof JComboBox){
            JComboBox combo = (JComboBox)object;
            String maintananceJob = (String)combo.getSelectedItem();
            mechanicSelected = mechanicHashtable.get(maintananceJob);
        }
        if(object instanceof JButton) {
            JButton button = (JButton)object;
            String s = button.getActionCommand();
            if(s.equals("Main Menu")){
                frame.getContentPane().removeAll();
                mechanicHashtable.clear();
                mechanicSelected=null;
                MainWindow main = new MainWindow(frame,shop);
            }
            else if(s.equals("Add")){
                frame.getContentPane().removeAll();
                if(mechanicSelected!=null) {
                    maintenanceJob.updateMechanicNotes(note.getText());
                    maintenanceJob.addMechanic(mechanicSelected);
                    mechanicHashtable.clear();
                    mechanicSelected=null;

                    frame.getContentPane().removeAll();
                    paintGUI();
                }
            }
        }
    }
}
