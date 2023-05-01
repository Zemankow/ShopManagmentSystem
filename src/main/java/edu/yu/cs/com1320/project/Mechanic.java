package edu.yu.cs.com1320.project;

import java.util.Date;

public class Mechanic extends Person{
    Date yearHired;
    public Mechanic(String name, String address, int phoneNumber, Date yearHired){
        super(name,address,phoneNumber);
        this.yearHired=yearHired;
    }

    public double getYearsOnJob(){
        return -1;
        //FIXME
    }

}
