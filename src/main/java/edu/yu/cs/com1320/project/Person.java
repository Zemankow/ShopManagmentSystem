package edu.yu.cs.com1320.project;

public class Person {
    private String name = null;
    private String address = null;
    private int phoneNumber = -1;

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
    public void setName(String newName){
        name = newName;
    }
    public void setAddress(String newAddress){
        address = newAddress;
    }
    public void setPhoneNumber(int newPhoneNumber){
        phoneNumber = newPhoneNumber;
    }
}
