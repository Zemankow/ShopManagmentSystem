package edu.yu.cs.com1320.project;

import java.util.Date;
import java.util.List;

public class Car {
    String vin, make, model;
    Date year;
    double odometer;
    List<MaintnenceJob> previous, current, recomended;//todo make list

    public Car(){
        //fixme
    }

    private List<MaintnenceJob> getRecomendedMaintanancec(){
        return null;
    }


}
