package org.example;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {


        List<Integer> packageLists = new Vector<>();

        try {
            Semaphore sendPackageSemaphore = new Semaphore(3);
            Semaphore receivePackageSemaphore = new Semaphore(3);

            receivePackageSemaphore.acquire(3);

            Thread sendPackageThread = new Thread(new SendPackageSemaphoreTask(sendPackageSemaphore, receivePackageSemaphore,packageLists)); //
            Thread receivePackageThread = new Thread(new ReceivePackageSemaphoreTask(receivePackageSemaphore,sendPackageSemaphore,packageLists));

            sendPackageThread.start();
            receivePackageThread.start();



        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Programa terminado.");


    }
}