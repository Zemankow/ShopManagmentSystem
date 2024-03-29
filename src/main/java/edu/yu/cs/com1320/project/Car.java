package edu.yu.cs.com1320.project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Car implements Comparable<Car>{
    private String vin, make, model;
    private int year;
    private LocalDate carNeeded;
    private int odometer;
    private List<MaintenanceJob> previous;
    private List<MaintenanceJob> current;
    private List<MaintenanceJob> recommended;



    public Car(String vin, String make, String model, int year, int odometer){

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
    /**
     * adds a new maintenance job to car*/
    public void addMaintenanceJob(MaintenanceJob.MaintenanceType type, String complaint){
        MaintenanceJob mj = new MaintenanceJob(this.odometer,type,complaint);
        current.add(mj);
    }
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
    public int getYear(){
        return year;
    }
    public boolean isComplete(){
        if(vin.isEmpty()||make.isEmpty()||model.isEmpty()||year==0){
            return false;
        }
        return true;
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
        if (this.carNeeded.isAfter(other.getCarNeeded()))
            return 1;
        else if (this.carNeeded.isBefore(other.getCarNeeded()))
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return make + "," + model + "," + year + "," + vin;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj instanceof Car){
            obj = (Car)obj;
            if(((Car) obj).vin.equals(this.vin)
                && ((Car) obj).make.equals(this.make)
                &&((Car) obj).model.equals(this.model)
                && ((Car) obj).year == this.year){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.toString().hashCode();
    }
}
