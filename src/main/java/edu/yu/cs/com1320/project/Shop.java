package edu.yu.cs.com1320.project;

import java.util.List;
import java.util.Queue;

public class Shop {

    List<Car> bay;
    Queue<Car> requiresWork;
    List<Car> readyForPickup;
    List<Customer> customers;


    public void addCar(Car car){
        requiresWork.add(car);
    }
    public List<Car> getReadyForPickup(){
        return readyForPickup;
    }
    public void moveToReadyForPickup(Car car){
        bay.remove(car);
        readyForPickup.add(car);
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }

}
