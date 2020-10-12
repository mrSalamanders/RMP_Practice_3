package ru.itmo.practice3;

import java.util.ArrayList;

public class Trd extends Thread {
    private Object lock;
    private static Integer count = 0;
    public Trd(Object object) {
        this.lock = object;
    }
    public static void incCount() {
        count++;
    }
    @Override
    public void run() {
        while (count < 10) {
            synchronized (lock) {
                try {
                    System.out.println(getName());
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Trd.incCount();
        }
    }
    public static void task1() {
        ArrayList<CounterThread> ts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ts.add(new CounterThread());
        }
        for (CounterThread ct : ts) {
            ct.start();
        }
    }
    public static void task2() throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(getState());
            }
        };
        System.out.println(thread.getState());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState());
    }
    public static void task3() {
        Counter c = new Counter();
        ArrayList<CounterThread2> ts = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            ts.add(new CounterThread2(c));
        }
        for (CounterThread2 ct : ts) {
            ct.start();
        }
        System.out.println(c.getCount());
    }
    public static void task4() {
        Object lock = new Object();
        new Trd(lock).start();
        new Trd(lock).start();
    }
}
class CounterThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        };
    }
}
class CounterThread2 extends Thread {
    public Counter c;
    public CounterThread2(Counter cout) {
        c = cout;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            c.increment();
        };
    }
    public int getC() {
        return c.getCount();
    }
}
class Counter {
    int count = 0;
    public void increment() {
        count = count + 1;
    }
    public int getCount() {
        return count;
    }
}