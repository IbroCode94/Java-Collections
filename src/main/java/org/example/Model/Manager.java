package org.example.Model;

import enums.Role;

public class Manager extends Person{

    Mall mall;
    Cashier cashier;

    public Manager(String name, int age, Role position, Mall mall) {
        super(name, age, position);
        this.mall = mall;

    }



    public Mall getMall() {
        return mall;
    }

    public void setMall(Mall mall) {
        this.mall = mall;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }


    public void setNumberOfDays(Cashier cashier, int daysAbsent) {
        cashier.setNoOfDaysAbsent(daysAbsent);
    }

}
