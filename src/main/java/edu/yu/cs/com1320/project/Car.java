package edu.yu.cs.com1320.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Car {
    String vin, make, model;
    Date year;
    double odometer;
    List<MaintenanceJob> previous;



    List<MaintenanceJob> current;
    List<MaintenanceJob> recomended;//todo make list

    public Car(String vin, String make, String model,Date year, double odometer){
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.odometer = odometer;
        previous = new ArrayList<>();
        current = new ArrayList<>();
        recomended = new ArrayList<>();
    }

    public void addMaintenanceJob(MaintenanceJob maintenanceJob){
        current.add(maintenanceJob);
    }


    //Getters
    public double getOdometer(){
        return odometer;
    }
    public List<MaintenanceJob> getRecomendedMaintanancec(){
        return null;
    }
    public List<MaintenanceJob> getPrevious() {
        return previous;
    }

    public List<MaintenanceJob> getCurrent() {
        return current;
    }

    public List<MaintenanceJob> getRecomended() {
        return recomended;
    }



}
