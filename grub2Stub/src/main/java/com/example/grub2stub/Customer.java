package com.example.grub2stub;

public class Customer {
    private int custID;
    private String custEmail;
    private int custTotalPoints;

    public Customer(int custID, String custEmail) {
        this.custID = custID;
        this.custEmail = custEmail;
    }



    public int getCustID() {
        return custID;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public int getCustTotalPoints() {
        return custTotalPoints;
    }

    public void setCustTotalPoints(int custTotalPoints) {
        this.custTotalPoints = custTotalPoints;
    }
}
