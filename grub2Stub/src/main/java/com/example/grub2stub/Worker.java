package com.example.grub2stub;

public class Worker {
    private static int nextWorkerId = 1;
    private int workerId;
    private String workerName;
    private boolean busyStatus = false;

    public Worker(String workerName) {
        this.workerId = nextWorkerId++;
        this.workerName = workerName;
    }

    public int getWorkerId() {
        return workerId;
    }

    public String getWorkerName() {
        return workerName;
    }
    public boolean getBusyStatus(){return busyStatus;}
    public void setBusyStatus(boolean status){this.busyStatus = status;}
}
