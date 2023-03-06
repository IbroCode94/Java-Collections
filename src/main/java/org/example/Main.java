package org.example;

import enums.Role;
import org.example.Model.*;
import java.util.*;
import service.customerService;
import service.implementation.customerServiceImpl;

public class Main {
 public static void main(String[] args) {
  Mall mall1 = new Mall("Tiger");
  mySheetReader myfile = new mySheetReader(mall1);
  String filePath = "src/main/resources/resources.utils/Book.xlsx";
  myfile.productList(filePath);
//        for(Products product: mall1.getProducts()) {
  System.out.println(mall1.getProductsList());
  myfile.productList(filePath);


  Manager manager = new Manager("John", 30, Role.MANAGER, mall1);

  Cashier cashier1 = new Cashier("Mary", 20, Role.CASHIER, "4321", mall1, true);

  Cashier cashier2 = new Cashier("Sanusi", 23, Role.CASHIER, "5678", mall1, true);

 mall1.setCashiersList(cashier1);
mall1.setCashiersList(cashier2);

       Customer customer1 = new Customer("Bright",30,Role.CUSTOMER,10000,mall1);
      Customer customer2 = new Customer("Malik",20, Role.CUSTOMER,40000,mall1);
     Customer customer3 = new Customer("Emmy",10000, Role.CUSTOMER,30000,mall1);

//     customerServiceImpl customerService = new customerServiceImpl();

     customer1.addGoods(mall1.getProductsList().get(0),10);
     customer1.addGoods(mall1.getProductsList().get(4),11);
    customer2.addGoods(mall1.getProductsList().get(1),9);
    customer2.addGoods(mall1.getProductsList().get(2),9);
    customer2.addGoods(mall1.getProductsList().get(3),9);
     customer3.addGoods(mall1.getProductsList().get(0), 7);
     customer3.addGoods(mall1.getProductsList().get(1), 14);
     customer3.addGoods(mall1.getProductsList().get(2), 4);
     customer3.addGoods(mall1.getProductsList().get(3), 2);

//
     Queue<Customer> fifoQueue = new LinkedList<>();

     customer1.addToFIFOQueue();
     customer2.addToFIFOQueue();
     customer3.addToFIFOQueue();


     customer1.addPriorityQueue();
     customer2.addPriorityQueue();
     customer3.addPriorityQueue();





     cashier1.viewCustomers();
cashier1.customerCheckOutFIFO(mall1.getFifo());

cashier1.checkOutPriorityCustomers(mall1.getQueue());

//        cashier1.checkOut(customer1);
//      cashier2.checkOut(customer2);
//       cashier2.checkOut(customer3);

//
//        managerServiceImpl managerService = new managerServiceImpl();
//        manager.setDaysAbsent(cashier1, 4);
//        managerService.fireCashier(mall1, cashier2);
//        managerService.fireCashier(mall1, cashier1);
//        System.out.println(mall1.getProducts().get(2).getQuantity());
 }
}