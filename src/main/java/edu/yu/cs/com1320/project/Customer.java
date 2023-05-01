package edu.yu.cs.com1320.project;

import java.util.*;
public class Customer extends Person{
    List<Car> cars;
    public Customer(String name, String address, int phoneNumber, List<Car> cars){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.cars = new ArrayList<>();
        this.cars.addAll(cars);
    }

}
