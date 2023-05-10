package edu.yu.cs.com1320.project.Graphics;

import edu.yu.cs.com1320.project.Car;
import edu.yu.cs.com1320.project.Shop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class SelectCarMaintanance implements ActionListener {
    JFrame frame;

    // JFrame

    // JButton
    static JButton mainMenu;
    Shop shop;

    Hashtable<String,Car> CarHashtable = new Hashtable<>();

    // label to display text

    // default constructor
    public SelectCarMaintanance(JFrame tmpFrame,Shop shop)
    {
        frame = tmpFrame;
        frame.setLayout(new FlowLayout());
        this.shop = shop;
        for(Car car: shop.getBay()){
            CarHashtable.put(car.toString(),car);
        }
        JComboBox carsBay = new JComboBox(CarHashtable.keySet().toArray());
        carsBay.addActionListener(this);
        mainMenu = new JButton("Main Menu");
        mainMenu.addActionListener(this);

        //Set up the picture.
        frame.getContentPane().setFont(frame.getContentPane().getFont().deriveFont(Font.ITALIC));

        //The preferred size is hard-coded to be the width of the
        //widest image and the height of the tallest image + the border.
        //A real program would compute this.

        //Lay out the demo.
        frame.getContentPane().add(mainMenu);

        frame.getContentPane().add(carsBay, BorderLayout.PAGE_START);
        frame.getContentPane().repaint();
    }


    public void actionPerformed(ActionEvent e)
    {
        Object object = e.getSource();

        if(object instanceof JComboBox){
            JComboBox cb = (JComboBox)e.getSource();
            String carName = (String)cb.getSelectedItem();
            Car carToUpdate = CarHashtable.get(carName);
            frame.getContentPane().removeAll();
            frame.getContentPane().repaint();
            ModifyMaintenance modifyMaintenance = new ModifyMaintenance(frame,shop,carToUpdate);
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
