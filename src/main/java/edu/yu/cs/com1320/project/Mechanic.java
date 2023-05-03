package edu.yu.cs.com1320.project;

import java.time.LocalDate;
import java.util.Date;

public class Mechanic extends Person{
    private LocalDate yearHired;
    public Mechanic(String name, String address, int phoneNumber, LocalDate yearHired){
        super(name,address,phoneNumber);
        this.yearHired=yearHired;
    }

    public LocalDate getYearHired(){
        return yearHired;
    }

    public double getYearsOnJob(){
        return -1;
        //FIXME
    }

}
