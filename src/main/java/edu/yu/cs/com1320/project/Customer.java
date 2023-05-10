package edu.yu.cs.com1320.project;

import java.util.*;
public class Customer extends Person{
    private List<Car> cars;
    public Customer(String name, String address, int phoneNumber){
        super(name,address,phoneNumber);
        this.cars = new ArrayList<>();
        this.cars.addAll(cars);
    }
    public void addCar(Car car){
        if(car!=null) {
            cars.add(car);
        }
    }
    public void addCars(List<Car> cars){
        if(cars!=null) {
            this.cars.addAll(cars);
        }
    }
    public void removeCar(Car car){
        if(car!=null) {
            cars.remove(car);
        }
    }
    public void removeCars(List<Car> cars){
        if(cars!=null) {
            this.cars.removeAll(cars);
        }
    }
    public List<Car> getCars() {
        return List.copyOf(cars);
    }
}
