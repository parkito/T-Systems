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

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new MainService());
        }
        executorService.shutdown();
        try {
            Thread.currentThread().sleep(7000);
            MainDAO.closeConnections();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void getTariffList() {
        tariffDAO.getTariffList();
    }

    public void run() {
        synchronized (objectForSynchronized) {
            tariffDAO.getTariffList();
        }
    }
}

