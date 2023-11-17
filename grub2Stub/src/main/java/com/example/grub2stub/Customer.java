package com.example.grub2stub;

public class Customer {
    private static int nextUserId = 1;
    private int custID;
    private String custEmail;
    private int custTotalPoints;
    private String seatNumber;

    public Customer(String custEmail) {
        this.custID = nextUserId++;
        this.custEmail = custEmail;
    }

    public void placeOrder(){

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

    public String getSeatNumber(){return seatNumber;}
    public void setSeatNumber(){this.seatNumber = seatNumber;}
}
