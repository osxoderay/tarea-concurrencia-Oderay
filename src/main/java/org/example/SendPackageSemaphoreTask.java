package org.example;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;

public class SendPackageSemaphoreTask implements Runnable {

    private Semaphore sendPackageSemaphore;
    private Semaphore receivePackageSemaphore;

    private List<Integer> packageNumList;

    public SendPackageSemaphoreTask(Semaphore sendPackageSemaphore, Semaphore receivePackageSemaphore, List<Integer> packageNumList) {
        this.sendPackageSemaphore = sendPackageSemaphore;
        this.receivePackageSemaphore = receivePackageSemaphore;
        this.packageNumList = packageNumList;
    }

    @Override
    public void run() {

        for (int i = 1; i < 100; i++){
            try {
                sendPackageSemaphore.acquire();
                System.out.println("Enviando paquete " + i);
                packageNumList.add(i);
                receivePackageSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
