package org.example.Model;

import java.util.*;

public class Mall {
    private String name;
    List<Cashier> cashiersList;
    List<Products> productsList;
private Queue<Customer> fifo = new LinkedList<>();
private Queue<Customer> queue = new PriorityQueue<>();


    public Mall() {
    }

    public Mall(String name) {
        this.name = name;
        this.cashiersList = new ArrayList<>();
        this.productsList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cashier> getCashiersList() {
        return cashiersList;
    }

    public void setCashiersList(Cashier cashier) {
        this.cashiersList.add(cashier);
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

    public Queue<Customer> getFifo() {
        return fifo;
    }

    public Queue<Customer> getQueue() {
        return queue;
    }
}
