package com.example.grub2stub;

public class Worker {
    private int workerId;
    private String workerName;

    public Worker(int workerId, String workerName) {
        this.workerId = workerId;
        this.workerName = workerName;
    }

    public int getWorkerId() {
        return workerId;
    }

    public String getWorkerName() {
        return workerName;
    }
}
