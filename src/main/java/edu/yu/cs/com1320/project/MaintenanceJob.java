package edu.yu.cs.com1320.project;

import java.time.LocalDateTime;
import java.util.*;
import java.time.LocalDate;

public class MaintenanceJob {
    private List<Mechanic> mechanics;
    public enum MaintenanceType {Oil,Brakes,Tires,Suspension,AC,Coolant,Lights,Engine,Transmission,BodyWork, Misc}
    public enum MaintenanceStage {ReadyForInspection,CustomerApproval,WaitingForParts,ReadyForWork,WorkBeingPreformed,WorkFinished}

    private MaintenanceType maintenanceType;
    private MaintenanceStage maintenanceStage;

    private double odometer;
    private String originalComplaint,mechanicNotes, preamble;
    private static LocalDateTime clock = LocalDateTime.now();
    private double price;
    private boolean paid;

    public MaintenanceJob(int odo,MaintenanceType type,String complaint){
        this.odometer = odo;
        this.maintenanceType=type;
        this.preamble = "Creating Work Order at "+clock.toString()+"\n";
        this.originalComplaint = complaint;
        maintenanceStage=MaintenanceStage.ReadyForInspection;
    }


    //Getters
    public List<Mechanic> getMechanics(){
        return List.copyOf(mechanics);
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

    public MaintenanceType getMaintenanceType(){
        return maintenanceType;
    }
    public MaintenanceStage getMaintenanceStage(){
        return maintenanceStage;
    }
    //Setters
    public void addMechanic(Mechanic mechanic){
        if(mechanic!=null){
            this.mechanics.add(mechanic);
        }

    }
    public void updateMechanicNotes(String note){
        String entry = "\n----------------"+clock.toString()+"----------------\n"+note;
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

    public void setMaintenanceType(MaintenanceType maintenanceType){
        this.maintenanceType = maintenanceType;
    }
    public void setMaintenanceStage(MaintenanceStage maintenanceStage){
        this.maintenanceStage = maintenanceStage;
    }

    @Override
    public String toString(){
        String type = "Maintenance Type: "+maintenanceType;
        String orig = "Original Complaint: "+originalComplaint;
        String div = "\n----------------\n";
        String mech = "Mechanic Notes: "+mechanicNotes;
        return ""+this.preamble+type+orig+div+mech;
    }

}
