package edu.yu.cs.com1320.project;

import edu.yu.cs.com1320.project.Graphics.AddCustomer;
import edu.yu.cs.com1320.project.Graphics.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Main {

    static Shop shop = new Shop();
    static JFrame frame;

    public static void main(String[] args) {
    {
        OpeningWindow();
    }

    }
    private static void OpeningWindow(){
        frame = new JFrame();
        //Display the window.
        frame.setVisible(true);
        frame.setSize(1000,1000);
        Car car = new Car("1","Toyota", "2019", LocalDate.now(),10000);
        car.addCurrentMaintenance(new MaintenanceJob(200000, MaintenanceJob.MaintenanceType.AC,"Ac is not working properly"));
        shop.addCar(car);
        shop.moveCarToBay();
        MainWindow mainWindow = new MainWindow(frame,shop);

    }
    private Car makeCar(){
        return new Car("4T1B11HK17845","Toyota", "Camry", LocalDate.of(2019,7,1),23000);
    }
    private Customer makeCustomer(){
        long num = 12056667777;
        return new Customer("jim","wilbur st.",num);
    }
    private void addMaintTest(){
        shop.addCustomer(makeCustomer());
        Customer index = shop.getCustomers().indexOf(makeCustomer());
    }





}