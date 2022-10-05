package org.example;

import java.util.concurrent.Semaphore;

public class ReceivePackageSemaphore implements Runnable{

    private Semaphore receivePackageSemaphore;
    private Semaphore sendPackageSemaphore;

    private int packageNum;

    public ReceivePackageSemaphore(Semaphore receivePackageSemaphore, Semaphore sendPackageSemaphore, int packageNum) {
        this.receivePackageSemaphore = receivePackageSemaphore;
        this.sendPackageSemaphore = sendPackageSemaphore;
        this.packageNum = packageNum;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++ ){

            try {
                receivePackageSemaphore.acquire();
                System.out.println("Recibido paquete" + packageNum);
                sendPackageSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
