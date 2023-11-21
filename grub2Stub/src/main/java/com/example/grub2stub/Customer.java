package com.example.grub2stub;

public class Customer {
    private static int nextUserId = 1;
    private int custID;
    private String custName;
    private int custTotalPoints;
    private String seatNumber;

    private String seatRow;

    public Customer(String name) {
        this.custID = nextUserId++;
        this.custName = name;
    }

    public int getCustID() {
        return custID;
    }

    public String getCustName() {
        return custName;
    }

    public int getCustTotalPoints() {
        return custTotalPoints;
    }

    public void setCustTotalPoints(int custTotalPoints) {
        this.custTotalPoints = custTotalPoints;
    }

    public String getSeatNumber(){
        return seatNumber;
    }
    public void setSeatNumber(String seatNumber){
        this.seatNumber = seatNumber;
    }

    public void setSeatRow(String seatRow){
        this.seatRow = seatRow;
    }

    public String getSeatRow(){
        return seatRow;
    }
}
