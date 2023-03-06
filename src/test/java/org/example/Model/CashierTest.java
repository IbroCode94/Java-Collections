package org.example.Model;

import enums.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashierTest {
    Mall mall1;
    Cashier cashier;
    Customer customer1;
    Customer customer2;
    Customer customer3;

    mySheetReader sheetReader;

    @BeforeEach
    void setup() {
         mall1 = new Mall("Target");
        sheetReader = new mySheetReader(mall1);
        sheetReader.productList("src/main/resources/resources.utils/Book.xlsx");
        customer1 = new Customer("Bright",30, Role.CUSTOMER,10000,mall1);
        customer2 = new Customer("Malik",20, Role.CUSTOMER,40000,mall1);
        customer3 = new Customer("Emmy",10000, Role.CUSTOMER,30000,mall1);
        cashier = new Cashier("Mary", 20, Role.CASHIER, "4321", mall1, true);

//
        customer1.addGoods(mall1.getProductsList().get(0),10);
        customer1.addGoods(mall1.getProductsList().get(4),11);
        customer2.addGoods(mall1.getProductsList().get(1),9);
        customer2.addGoods(mall1.getProductsList().get(2),9);
        customer2.addGoods(mall1.getProductsList().get(3),9);
        customer3.addGoods(mall1.getProductsList().get(0), 7);
        customer3.addGoods(mall1.getProductsList().get(1), 14);
        customer3.addGoods(mall1.getProductsList().get(2), 4);
        customer3.addGoods(mall1.getProductsList().get(3), 2);

    }

    @Test
    void customerCheckOutFIFO() {
        customer1.addToFIFOQueue();
        customer2.addToFIFOQueue();
        customer3.addToFIFOQueue();
      assertTrue(customer1.equals(mall1.getFifo().poll()));
    }

    @Test
    void checkOutPriorityCustomers() {
    }
}