package com.example.interview.concurency.day01;

/**
 * <Description>
 *  两个线程交替打印 I Love You.
 * @author wangxi
 */
public class PrintString {

    private static Object object = new Object();

    public synchronized void print(String threadName) {
        System.out.println(threadName + "  I Love You!");
    }

    public static void main(String[] args) throws InterruptedException {
        PrintString p = new PrintString();
        new Thread(() -> {
            synchronized (object) {
                System.out.println("  I Love You!");
                object.notify();
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (object) {
                System.out.println("  I Love You!");
                object.notify();
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

