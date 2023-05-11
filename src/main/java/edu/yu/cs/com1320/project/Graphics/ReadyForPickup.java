package edu.yu.cs.com1320.project.Graphics;

import edu.yu.cs.com1320.project.Car;
import edu.yu.cs.com1320.project.Customer;
import edu.yu.cs.com1320.project.Shop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class ReadyForPickup implements ActionListener {
    static JFrame frame;


    // JButton
    static JButton mainMenu;
    static JButton pickedUp;


    Shop shop;

    Car carSelected;


    static Hashtable<String,Car> CarHashtable = new Hashtable<>();

    static Customer customerSelected;
    public ReadyForPickup(JFrame tmpFrame, Shop shop) {

        frame = tmpFrame;
        frame.setLayout(new FlowLayout());
        this.shop = shop;

        paintGUI();
    }
    private void paintGUI(){

        for(Car car: shop.getReadyForPickup()){
            CarHashtable.put(car.toString(),car);
        }
        JComboBox carsBay = new JComboBox(CarHashtable.keySet().toArray());
        carsBay.addActionListener(this);
        mainMenu = new JButton("Main Menu");
        mainMenu.addActionListener(this);

        pickedUp = new JButton("Pick Up");
        pickedUp.addActionListener(this);

        //Set up the picture.
        frame.getContentPane().setFont(frame.getContentPane().getFont().deriveFont(Font.ITALIC));

        //The preferred size is hard-coded to be the width of the
        //widest image and the height of the tallest image + the border.
        //A real program would compute this.

        //Lay out the demo.
        frame.getContentPane().add(mainMenu);
        frame.getContentPane().add(pickedUp);

        frame.getContentPane().add(carsBay, BorderLayout.PAGE_START);
        frame.getContentPane().repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object object = e.getSource();

        if(object instanceof JComboBox){
            JComboBox combo = (JComboBox)object;
            String customer = (String)combo.getSelectedItem();
            carSelected = CarHashtable.get(customer);
        }
        if(object instanceof JButton) {
            JButton button = (JButton)object;
            String s = button.getActionCommand();

            if(s.equals("Main Menu")){
                frame.getContentPane().removeAll();
                CarHashtable.clear();
                MainWindow main = new MainWindow(frame,shop);
            }
            else if(s.equals("Pick Up")){
                frame.getContentPane().removeAll();
                shop.removeReadyForPickup(carSelected);
                CarHashtable.remove(carSelected.toString());
                frame.getContentPane().removeAll();
                paintGUI();

            }
        }
    }
}
