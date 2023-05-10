package edu.yu.cs.com1320.project;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;



public class ShopTest {
    private Shop shop;

    @Test
    public void testAddMaint(){
        shop = new Shop(4);

        shop.addCustomer(makeCustomer());
        int index = shop.getCustomers().indexOf(makeCustomer());
        shop.getCustomers().get(index).addCar(makeCar());

        shop.makeNewWorkOrder(makeCar(),MaintenanceJob.MaintenanceType.AC,"Ac is not working properly");

    }

    private Car makeCar() {
        return new Car("4T1B11HK17845", "Toyota", "Camry", LocalDate.of(2019, 7, 1), 23000);
    }

    private Customer makeCustomer() {
        long num = 1254488442;
        return new Customer("jim", "wilbur st.", num);
    }

    private void addMaintTest() {
        shop.addCustomer(makeCustomer());
    }
}
