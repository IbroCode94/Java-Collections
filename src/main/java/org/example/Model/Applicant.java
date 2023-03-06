package org.example.Model;

import enums.Role;

public class Applicant extends Person{
    private boolean isHired = false;

    public Applicant(String name, int age, Role position, boolean isHired) {
        super(name, age, position);
        this.isHired = isHired;
    }

    public boolean isHired() {
        return isHired;
    }

    public void setHired(boolean hired) {
        isHired = hired;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "isHired=" + isHired +
                "} " + super.toString();
    }
}
