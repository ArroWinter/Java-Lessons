package ru.sibsutis;


import java.util.*;

public class Main {
    static void filler(Collection<Dev> collection, Dev[] object) {
        for (int i = 0; i < 1000000; i++) {
            collection.add(object[i]);
        }
    }

    static void remover(Collection<Dev> collection) {
            collection.clear();
    }

    public static void main(String[] args) {
        String[] names = {"Anton", "Ivan", "Kirill", "Pavel", "Igor", "Fedor", "Dmitriy", "Maksim"};
        String[] departments = {"dev", "mod", "prod", "jun", "mid", "sen", "tst", "vis"};
        String[] numbers = {"03", "12", "26", "38", "49", "55", "77", "63"};

        Dev[] devs = new Dev[1000000];
        for (int i = 0; i < devs.length; i++) {
           devs[i] = new Dev(names[(int) (Math.random() * 7)], names[(int) (Math.random() * 7)] + "@gmail.com", departments[(int) (Math.random() * 7)]);
        }

        long startTime = System.nanoTime();
        Collection<Dev> collection = new ArrayList<>();
        filler(collection, devs);
        long stopTime = System.nanoTime();
        System.out.println("ArrayList time add:" + (stopTime - startTime) / 1_000_000);

        startTime = System.nanoTime();
        remover(collection);
        stopTime = System.nanoTime();
        System.out.println("ArrayList time remove:" + (stopTime - startTime) / 1_000_000);

        startTime = System.nanoTime();
        collection = new LinkedList<>();
        filler(collection, devs);
        stopTime = System.nanoTime();
        System.out.println("LinkedList time add:" + (stopTime - startTime) / 1_000_000);

        startTime = System.nanoTime();
        remover(collection);
        stopTime = System.nanoTime();
        System.out.println("LinkedList time remove:" + (stopTime - startTime) / 1_000_000);

        startTime = System.nanoTime();
        collection = new TreeSet<>();
        filler(collection, devs);
        stopTime = System.nanoTime();
        System.out.println("TreeSet time add:" + (stopTime - startTime) / 1_000_000);

        startTime = System.nanoTime();
        remover(collection);
        stopTime = System.nanoTime();
        System.out.println("TreeSet time remove:" + (stopTime - startTime) / 1_000_000);
    }
}