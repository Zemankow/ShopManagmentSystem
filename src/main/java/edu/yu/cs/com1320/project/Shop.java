package edu.yu.cs.com1320.project;

import java.util.*;

public class Shop {

    private List<Car> bay;
    private Queue<Car> requiresWork;
    private List<Car> readyForPickup;
    private List<Customer> customers;


    public Shop(){
        this.requiresWork = new PriorityQueue<>();
        this.bay = new ArrayList<>();
        this.readyForPickup = new ArrayList<>();
        this.customers =  new ArrayList<>();
    }
    public void addCar(Car car){
        this.requiresWork.add(car);
    }
    public List<Car> getReadyForPickup(){
        return List.copyOf(readyForPickup);
    }
    public List<Customer> getCustomers(){
        return List.copyOf(customers);
    }
    public List<Car> carsInBay(){
        return List.copyOf(bay);
    }
    public void moveToReadyForPickup(Car car){
        this.bay.remove(car);
        this.readyForPickup.add(car);
    }
    public void addCustomer(Customer customer){
        this.customers.add(customer);
    }
    public void removeCustomer(Customer customer){
        if(customer!=null){
            this.customers.remove(customer);
        }
    }

}
