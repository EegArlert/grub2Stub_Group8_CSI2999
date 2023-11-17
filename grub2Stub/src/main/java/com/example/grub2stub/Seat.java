package com.example.grub2stub;

public class Seat {
    private int seatID;
    private int seatNumber;
    private boolean isAvailable;

    public Seat(int seatID, int seatNumber, boolean isAvailable) {
        this.seatID = seatID;
        this.seatNumber = seatNumber;
    }

    public int getSeatID() {
        return seatID;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
