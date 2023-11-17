package com.example.grub2stub;

import java.util.ArrayList;
import java.util.List;
public class OrderDelivery {
    private List<Worker> availableWorkers;

    public OrderDelivery(){
        this.availableWorkers = new ArrayList<>();
        initializeWorkers();
    }

    private void initializeWorkers(){
        //add workers to list
    }

    public void assignWorker(OrderDetail order){
        //Assign some available worker to order
    }

    private Worker findAvailableWorker(){
        //check status of workers on list to find one that is not busy
        return null; //
    }

    //function to track status of order
    
    //function to find worker by order #








}
