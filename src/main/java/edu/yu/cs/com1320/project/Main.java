package edu.yu.cs.com1320.project;

import edu.yu.cs.com1320.project.Graphics.AddCustomer;
import edu.yu.cs.com1320.project.Graphics.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    static Shop shop = new Shop();
    static JFrame frame;

    public static void main(String[] args) {
        OpeningWindow();

    }
    private static void OpeningWindow(){
        frame = new JFrame();
        //Display the window.
        frame.setVisible(true);
        frame.setSize(1000,1000);
        frame.getContentPane().removeAll();

        MainWindow mainWindow = new MainWindow(frame,shop);

    }
}