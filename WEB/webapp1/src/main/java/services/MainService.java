package services;

import manipulating.ClientDAO;
import manipulating.MainDAO;
import manipulating.TariffDAO;
import manipulating.TariffOptionDAO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Artyom Karnov on 8/22/16.
 * artyom-karnov@yandex.ru
 **/
public class MainService implements Runnable {
    Object objectForSynchronized = new Object();
    TariffDAO tariffDAO = new TariffDAO();
    TariffOptionDAO tariffOptionDAO = new TariffOptionDAO();
    ClientDAO clientDAO = new ClientDAO();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new MainService());
        }
        executorService.shutdown();
        Thread.currentThread().join();
//        MainDAO.closeConnections();

    }

    public void getTariffList() {
        tariffDAO.getTariffList();
    }

    synchronized public void run() {
//        synchronized (objectForSynchronized) {
        tariffDAO.getTariffList();
//        }
    }
}

