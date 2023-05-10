package edu.yu.cs.com1320.project.Graphics;

import edu.yu.cs.com1320.project.Car;
import edu.yu.cs.com1320.project.Shop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class SelectCarMaintanance implements ActionListener {
    JFrame frame;
    static JTextField name;
    static JTextField address;
    static JTextField phoneNumber;

    // JFrame

    // JButton
    static JButton b;
    Shop shop;

    Hashtable<String,Car> CarHashtable = new Hashtable<>();

    // label to display text

    // default constructor
    public SelectCarMaintanance(JFrame tmpFrame,Shop shop)
    {
        frame = tmpFrame;
        frame.setLayout(new FlowLayout());

        for(Car car: shop.getBay()){
            CarHashtable.put(car.toString(),car);
        }
        System.out.println(CarHashtable.size());
        JComboBox carsBay = new JComboBox(CarHashtable.keySet().toArray());
        carsBay.addActionListener(this);

        //Set up the picture.
        frame.getContentPane().setFont(frame.getContentPane().getFont().deriveFont(Font.ITALIC));

        //The preferred size is hard-coded to be the width of the
        //widest image and the height of the tallest image + the border.
        //A real program would compute this.

        //Lay out the demo.

        frame.getContentPane().add(carsBay, BorderLayout.PAGE_START);
        frame.getContentPane().repaint();
    }


    public void actionPerformed(ActionEvent e)
    {
        JComboBox cb = (JComboBox)e.getSource();
        String carName = (String)cb.getSelectedItem();
        Car carToUpdate = CarHashtable.get(carName);

    }
}
