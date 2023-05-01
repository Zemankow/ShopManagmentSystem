package edu.yu.cs.com1320.project;

public class Person {
    protected String name = null;
    protected String address = null;
    protected int phoneNumber = -1;

    Person(String name, String address, int phoneNumber){
        this.name= name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
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
