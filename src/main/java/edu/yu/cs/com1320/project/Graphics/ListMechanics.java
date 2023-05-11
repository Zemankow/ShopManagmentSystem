package edu.yu.cs.com1320.project.Graphics;

import edu.yu.cs.com1320.project.Customer;
import edu.yu.cs.com1320.project.Mechanic;
import edu.yu.cs.com1320.project.Shop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class ListMechanics implements ActionListener {

    static JFrame frame;


    // JButton
    static JButton mainMenu;

    static JButton b;
    Shop shop;

    static Hashtable<String, Mechanic> mechanicHashtable = new Hashtable<>();


    static Customer customerSelected;
    public ListMechanics(JFrame tmpFrame, Shop shop) {

        frame = tmpFrame;

        frame.setLayout(new FlowLayout());

        this.shop = shop;

        paintGUI();
    }
    private void paintGUI(){
        mainMenu = new JButton("Main Menu");



        mainMenu.addActionListener(this);
        mainMenu.setBounds(500,0,200,30);
        // addActionListener to button

        for(Mechanic mechanic: shop.getMechanics()){
            mechanicHashtable.put(mechanic.toString(),mechanic);
        }
        JComboBox customers = new JComboBox(mechanicHashtable.keySet().toArray());
        customers.addActionListener(this);
        frame.getContentPane().setFont(frame.getContentPane().getFont().deriveFont(Font.ITALIC));

        frame.getContentPane().add(customers, BorderLayout.PAGE_START);
        frame.getContentPane().add(mainMenu);

        frame.getContentPane().repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object object = e.getSource();
        if(object instanceof JComboBox){
            JComboBox combo = (JComboBox)object;
            String maintananceJob = (String)combo.getSelectedItem();
            customerSelected = mechanicHashtable.get(maintananceJob);
        }
        if(object instanceof JButton) {
            JButton button = (JButton)object;
            String s = button.getActionCommand();
            if(s.equals("Main Menu")){
                frame.getContentPane().removeAll();
                MainWindow main = new MainWindow(frame,shop);
            }
        }
    }
}
