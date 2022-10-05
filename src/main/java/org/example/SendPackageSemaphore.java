package org.example;

import java.util.concurrent.Semaphore;

public class SendPackageSemaphore implements Runnable {

    private Semaphore sendPackageSemaphore;
    private Semaphore receivePackageSemaphore;

    private int packageNum;

    public SendPackageSemaphore(Semaphore sendPackageSemaphore, Semaphore receivePackageSemaphore, int packageNum) {
        this.sendPackageSemaphore = sendPackageSemaphore;
        this.receivePackageSemaphore = receivePackageSemaphore;
        this.packageNum = packageNum;
    }


    @Override
    public void run() {

        for (int i = 0; i < 100; i++){
            try {
                sendPackageSemaphore.acquire();
                System.out.println("Enviando paquete" + packageNum);
                receivePackageSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
