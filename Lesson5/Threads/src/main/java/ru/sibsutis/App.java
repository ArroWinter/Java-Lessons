package ru.sibsutis;


import java.util.ArrayDeque;
import java.util.Queue;

/*class Product {
    private String name = "Product";

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}*/

class Store {
    private Queue<Store> storage;

    public Store() {
        this.storage = new ArrayDeque<>();
    }

     Store get() {
        while (storage.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        Store store1 = storage.remove();
        System.out.println("Покупатель купил товар" + "\nТоваров осталось: " + storage.size());
        notify();
        return store1;
    }

    synchronized void put(Store store) {
        while (storage.size() > 100) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        for (int i = 0; i < 10; i++) {
            storage.add(store);
        }
        System.out.println("Производитель произвёл 10 товор" + "\nТоваров осталось: " + storage.size());
        notify();
    }
}

class Producer implements Runnable {
    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            store.put(store);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            store.get();
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class App {
    public static void main(String[] args) {
        Store store = new Store();
        new Thread(new Producer(store)).start();
        for (int i = 0; i < 50; i++) {
            new Thread(new Consumer(store)).start();
        }
    }
}
