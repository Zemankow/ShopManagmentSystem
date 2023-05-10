package edu.yu.cs.com1320.project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Car implements Comparable<Car>{
    private String vin, make, model;
    private LocalDate year;
    private LocalDate carNeeded;
    private double odometer;
    private List<MaintenanceJob> previous;
    private List<MaintenanceJob> current;
    private List<MaintenanceJob> recommended;



    public Car(String vin, String make, String model,LocalDate year, double odometer){
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.odometer = odometer;
        previous = new ArrayList<>();
        current = new ArrayList<>();
        recommended = new ArrayList<>();
    }


    //Setters
    public void addMaintenanceJob(MaintenanceJob maintenanceJob){
        current.add(maintenanceJob);
    }
    public void setCarNeeded(LocalDate newDate){
        this.carNeeded = newDate;
    }


    //Getters
    public String getVin(){
        return vin;
    }
    public String getMake(){
        return make;
    }
    public String getModel(){
        return model;
    }
    public double getOdometer(){
        return odometer;
    }

    public List<MaintenanceJob> getPreviousMaintenance() {
        return List.copyOf(previous);
    }

    public List<MaintenanceJob> getCurrentMaintenance() {
        return List.copyOf(current);

    }

    public List<MaintenanceJob> getRecommendedMaintenance() {
        return List.copyOf(recommended);
    }
    public LocalDate getYear(){
        return year;
    }



    public void removePreviousMaintenance(MaintenanceJob maintenanceJob) {
        previous.remove(maintenanceJob);
    }

    public void removeCurrentMaintenance(MaintenanceJob maintenanceJob) {
        current.remove(maintenanceJob);
    }

    public void removeRecommendedMaintenance(MaintenanceJob maintenanceJob) {
        recommended.remove(maintenanceJob);
    }


    public void addPreviousMaintenance(MaintenanceJob maintenanceJob) {
        if(maintenanceJob!=null) {
            previous.add(maintenanceJob);
        }
    }

    public void addCurrentMaintenance(MaintenanceJob maintenanceJob) {
        if(maintenanceJob!=null) {
            current.add(maintenanceJob);
        }
    }

    public void addRecommendedMaintenance(MaintenanceJob maintenanceJob) {
        if(maintenanceJob!=null) {
            recommended.add(maintenanceJob);
        }
    }

    public LocalDate getCarNeeded(){
        return carNeeded;
    }

    @Override
    public int compareTo(Car other) {
        return this.carNeeded.compareTo(other.getCarNeeded());
    }

    @Override
    public String toString() {
        return make + "," + model + "," + year .getYear() + "," + vin;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Car tmpCar){
            return tmpCar.toString().equals(this.toString());
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.toString().hashCode();
    }
}
