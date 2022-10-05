package org.example;

import java.util.List;
import java.util.concurrent.Semaphore;

public class ReceivePackageSemaphoreTask implements Runnable{

    private Semaphore receivePackageSemaphore;
    private Semaphore sendPackageSemaphore;

    private List<Integer> packageNumList;

    public ReceivePackageSemaphoreTask(Semaphore receivePackageSemaphore, Semaphore sendPackageSemaphore, List<Integer> packageNumList) {
        this.receivePackageSemaphore = receivePackageSemaphore;
        this.sendPackageSemaphore = sendPackageSemaphore;
        this.packageNumList = packageNumList;
    }

    @Override
    public void run() {

        for (int i = 1; i < 100; i++ ){

            try {
                receivePackageSemaphore.acquire();
                System.out.println("Paquete " + i + " recibido");
                packageNumList.remove(0);
                sendPackageSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}