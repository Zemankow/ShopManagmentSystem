package edu.yu.cs.com1320.project;

import java.util.*;
import java.util.Date;

public class MaintenanceJob {
    List<Mechanic> mechanics;
    public enum maintenanceTypes {OIL,Brakes,Tires}
    double odometer;
    String description;
    // Date date;
    double price;
    boolean paid;


    //Getters
    public List<Mechanic> getMechanics(){
        return new ArrayList<>(mechanics);
    }
    public String getDescription(){
        return description;
    }
   /*
    public Data getDate(){
        return date;
    }
    */

    public double getOdometer(){
        return odometer;
    }
    public  double getPrice(){
        return price;
    }
    public boolean wasPaid(){
        return paid;
    }
    //Setters
    public void addMechanic(Mechanic mechanic){

    }
    public void setDescription(String description){
        this.description =description;
    }
    /*
    public void setDate(Date date){
        this.date = date;
    }
     */
    public void setOdometer(double odometer){
        this.odometer = odometer;
    }
    public  void setPrice(double price){
        this.price = price;
    }
    public void setPaid(boolean paid){
        this.paid = paid;
    }


}
