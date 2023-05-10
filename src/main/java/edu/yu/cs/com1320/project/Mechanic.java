package edu.yu.cs.com1320.project;

import java.time.LocalDate;

public class Mechanic extends Customer{
    private LocalDate yearHired;
    public Mechanic(String name, String address, int phoneNumber, LocalDate yearHired){
        super(name,address,phoneNumber);
        this.yearHired=yearHired;
    }

    public LocalDate getYearHired(){
        return yearHired;
    }

    public double getYearsOnJob(){
        return LocalDate.now().getYear() - yearHired.getYear();
    }

}
