package edu.yu.cs.com1320.project;

public class Person {
    private String name = null;
    private String address = null;
    private long phoneNumber = -1;

    Person(String name, String address, long phoneNumber){
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
    public long getPhoneNumber(){
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

    @Override
    public String toString() {
        return name +", "+ address+", " +phoneNumber;
    }

    @Override
    public int hashCode(){
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Person tmpCustomer){
            return tmpCustomer.toString().equals(this.toString());
        }
        return false;
    }
}
