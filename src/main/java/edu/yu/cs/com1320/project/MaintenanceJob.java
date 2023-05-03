package edu.yu.cs.com1320.project;

import java.time.LocalDateTime;
import java.util.*;
import java.time.LocalDate;

public class MaintenanceJob {
    List<Mechanic> mechanics;
    public enum maintenanceTypes {OIL,Brakes,Tires}
    public enum maintenanceStage {OIL,Brakes,Tires}

    private double odometer;
    private String originalComplaint,mechanicNotes;
    private LocalDateTime clock;
    private double price;
    private boolean paid;

    public MaintenanceJob(int odo,MaintenanceType type,String complaint){
        this.odometer = odo;
        this.maintenanceType=type;
        this.originalComplaint = complaint;
        maintenanceStage=MaintenanceStage.ReadyForInspection;
    }


    //Getters
    public List<Mechanic> getMechanics(){
        return new ArrayList<>(mechanics);
    }
    public String originalComplaint(){
        return originalComplaint;
    }
    public String getMechanicNotes(){
        return mechanicNotes;
    }

    public LocalDateTime getDate(){
        return clock;
    }

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
    public void updateMechanicNotes(String note){
        String entry = "/n----------------"+clock+"n----------------/n"+note;
        this.mechanicNotes =mechanicNotes+=entry;
    }

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
