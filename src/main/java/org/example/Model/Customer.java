package org.example.Model;

import enums.Role;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Customer extends Person implements Comparable<Customer>{
    private double funds;
    private ArrayList<Products> Goods;
    Mall mall;

    public Customer(String name, int age, Role position, double funds, Mall mall) {
        super(name, age, position);
        this.funds = funds;
        this.Goods = new ArrayList<>();
        this.mall = mall;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }

    public ArrayList<Products> getGoods() {
        return Goods;
    }

    public void setGoods(ArrayList<Products> goods) {
        Goods = goods;
    }

    public Mall getMall() {
        return mall;
    }

    public void setMall(Mall mall) {
        this.mall = mall;
    }
    public void payForGoods(double amount) {
        this.funds -= amount;
    }
    public void addGoods(Products products, int volume) {
            Products selected = new Products(products.getName(),products.getCategory(),products.getPrice(), volume);
            for (Products p: mall.getProductsList()) {
                if(p.getName().equals(selected.getName())){
                    if(p.getQuantity() == 0){
                        System.out.println("OUT OF STOCK");
                    }else if (p.getQuantity() < selected.getQuantity()) {
                        System.out.println("SORRY NOT ENOUGH");
                    }else {
                        Goods.add(selected);
                        System.out.println(getName() + " Added " + volume + " " + selected.getName() + " to the cart");

                        int remainder = p.getQuantity() - volume;
                        p.setQuantity(remainder);
                        break;
                    }
                }
            }



    }


    public void addToFIFOQueue() {
        mall.getFifo().add(this);
    }
    public void addPriorityQueue() {
        mall.getQueue().add(this);
    }
    public int getGoodsSize(){
        return  Goods.size();
    }

    @Override
    public int compareTo(Customer o) {
        return o.getGoodsSize() - this.getGoodsSize();
    }
}
