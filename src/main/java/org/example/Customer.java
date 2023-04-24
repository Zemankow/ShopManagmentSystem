package org.example;

import java.util.*;
public class Customer implements Person{
    String name;
    String address;
    int phoneNumber;
    List<Car> cars;
    public Customer(String name, String address, int phoneNumber, List<Car> cars){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.cars.addAll(cars);
    }

}
