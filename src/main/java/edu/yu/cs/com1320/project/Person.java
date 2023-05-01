package edu.yu.cs.com1320.project;

public abstract class Person {
    protected String name = null;
    protected String address = null;
    protected int phoneNumber = -1;

    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public int getPhoneNumber(){
        return phoneNumber;
    }
}
