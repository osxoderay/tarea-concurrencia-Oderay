package org.example;

import java.util.concurrent.Semaphore;

public class ReceivePackageSemaphore implements Runnable{

    private Semaphore receivePackageSemaphore;
    private Semaphore sendPackageSemaphore;

    public ReceivePackageSemaphore(Semaphore receivePackageSemaphore, Semaphore sendPackageSemaphore) {
        this.receivePackageSemaphore = receivePackageSemaphore;
        this.sendPackageSemaphore = sendPackageSemaphore;
    }

    @Override
    public void run() {

    }
}
