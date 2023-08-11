package edu.yu.cs.com1320.project;

import edu.yu.cs.com1320.project.Graphics.MainWindow;

import javax.swing.*;

public class Main {

    static Shop shop;
    static JFrame frame;

    public static void main(String[] args) {
    {
        shop =  new Shop(5);
        OpeningWindow();
    }

    }
    private static void OpeningWindow(){
        frame = new JFrame();
        //Display the window.
        frame.setVisible(true);
        frame.setSize(1000,1000);
        //shop.makeNewWorkOrder(car,MaintenanceJob.MaintenanceType.AC,"Ac is not working properly");
        MainWindow mainWindow = new MainWindow(frame,shop);

    }
}
