package edu.yu.cs.com1320.project;

import java.util.*;

public class Shop {



    int baySize=0;
    private List<Car> bay;
    private Queue<Car> requiresWork;
    private List<Car> readyForPickup;
    private List<Customer> customers;



    private List<Mechanic> mechanics;



    public Shop(int baySize){
        this.baySize = baySize;
        this.requiresWork = new PriorityQueue<>(new workComparator());
        this.bay = new ArrayList<>();
        this.readyForPickup = new ArrayList<>();
        this.customers =  new ArrayList<>();
        this.mechanics = new ArrayList<>();
    }
    /**
     * this method should not be here but Eitan belives it should
     * You should use #makeNewWorkOrder()*/
    public void addCar(Car car){
        if(car!=null) {
            this.requiresWork.add(car);
        }
        if(bay.size()<baySize){
            moveCarToBay();
        }
    }
    /**
     * Generates a work order for a given car and adds the car to req. wrk. list.
     * @param car the car to attach the order to
     * @param type the type of maintenance
     * @param complaint the inital complaint
     * */
    public void makeNewWorkOrder(Car car, MaintenanceJob.MaintenanceType type, String complaint){
        Car c = getCarFromStorage(car);
        c.addMaintenanceJob(type,complaint);
        requiresWork.add(c);
    }
    /**
     * Gets car from storage if belongs to a customer
     * @param car the car to search for
     * @return the car stored or the same car if new*/
    private Car getCarFromStorage(Car car){
        Car ourcar = car;
        for(Customer cus : customers){
            for(Car ca : cus.getCars()){
                if(ca.equals(car)){
                    ourcar=ca;
                }
            }
        }
        return ourcar;
    }
    public void moveCarToBay(){
        if(!requiresWork.isEmpty()){
            bay.add(requiresWork.remove());
        }
    }
    public List<Mechanic> getMechanics() {
        return mechanics;
    }
    public List<Car> getReadyForPickup(){
        return List.copyOf(readyForPickup);
    }
    public List<Customer> getCustomers(){
        return List.copyOf(customers);
    }
    public List<Car> getBay(){
        return List.copyOf(bay);
    }
    public void moveToReadyForPickup(Car car){
        this.bay.remove(car);
        this.readyForPickup.add(car);
    }
    public void addCustomer(Customer customer){
        this.customers.add(customer);
    }

    public void addMechanic(Mechanic mechanic){
        this.mechanics.add(mechanic);
    }
    public void removeCustomer(Customer customer){
        if(customer!=null){
            this.customers.remove(customer);
        }
    }
    public void removeReadyForPickup(Car car){
        this.readyForPickup.remove(car);
    }


    static class workComparator implements Comparator<Car>{

        // Overriding compare()method of Comparator
        // for descending order of cgpa
        public int compare(Car car1, Car car2) {
           return car1.compareTo(car2);
        }

    }

}
