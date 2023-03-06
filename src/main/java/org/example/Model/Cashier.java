package org.example.Model;

import enums.Role;

import java.util.Queue;

public class Cashier extends Person{
    private String workID;
    Mall mall;
    private boolean employed;
    private int noOfDaysAbsent = 0;

    public Cashier(String name, int age, Role position, String workID, Mall mall, boolean employed) {
        super(name, age, position);
        this.workID = workID;
        this.mall = mall;
        this.employed = employed;
    }



    public String getWorkID() {
        return workID;
    }

    public void setWorkID(String workID) {
        this.workID = workID;
    }

    public Mall getMall() {
        return mall;
    }

    public void setMall(Mall mall) {
        this.mall = mall;
    }

    public boolean isEmployed() {
        return employed;
    }

    public void setEmployed(boolean employed) {
        this.employed = employed;
    }

    public int getNoOfDaysAbsent() {
        return noOfDaysAbsent;
    }

    public void setNoOfDaysAbsent(int noOfDaysAbsent) {
        this.noOfDaysAbsent += noOfDaysAbsent;
    }


    public void checkOut(Customer customer) {
        double totalPrice = 0.0;
//        System.out.println();
        for(Products items : customer.getGoods()) {
            System.out.println("item: " + items.getName() + " volume: " + items.getQuantity());
            totalPrice += items.getPrice() * items.getQuantity();

        }
        if(customer.getFunds() >= totalPrice) {
            customer.payForGoods(totalPrice);
            issueReceipt(customer, totalPrice);
        }else {
            System.out.println("Insufficient Balance.");
        }
        System.out.println("Goods Total: " + totalPrice);


    }
    public void viewCustomers(){
        for(Customer c : mall.getFifo()){
            System.out.println(c.getName());
        }

    }
    public void issueReceipt(Customer customer, double totalPrice) {
        System.out.println();
        System.out.println("Receipt");
        System.out.println("Name " + customer.getName());
        System.out.println("Total " + totalPrice);
        //System.out.println("Balance " + );
        System.out.println("sold by " + getName() + " " + workID);
        System.out.println("Thanks for Your Patronage");
        System.out.println("****************");
        System.out.println("Items Purchased");

        customer.getGoods().clear();
    }

    public void customerCheckOutFIFO(Queue<Customer> fifo){
        while (!mall.getFifo().isEmpty()) {
            Customer line = mall.getFifo().poll();
            checkOut(line);
            System.out.println(line.getName() + " checked out");
            System.out.println();
        }

    }


    public void checkOutPriorityCustomers(Queue<Customer> queue){
        while(!mall.getQueue().isEmpty()){
            Customer queueLine = queue.poll();
           checkOut(queueLine);
            System.out.println(queueLine.getName() + " Checked out on list of Priority");
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "workID='" + workID + '\'' +
                ", mall=" + mall +
                ", employed=" + employed +
                ", noOfDaysAbsent=" + noOfDaysAbsent +
                "} " + super.toString();
    }
}
