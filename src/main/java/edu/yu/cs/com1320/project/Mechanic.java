package edu.yu.cs.com1320.project;

import java.util.Date;

public class Mechanic implements Person{
    String name;
    String address;
    int phoneNumber;
    Date yearHired;
    public Mechanic(String name, String address, int phoneNumber, Date yearHired){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.yearHired=yearHired;
    }

    public double getYearsOnJob(){
        return -1;
        //FIXME
    }

}
