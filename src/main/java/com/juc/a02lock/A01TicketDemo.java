package com.juc.a02lock;

/**
 * @author eniac555
 * @date 2023/5/13
 * @description: synchronized锁的简单使用
 */
public class A01TicketDemo {

    static final Object lock = new Object();
    int ticketNum = 10;


    public synchronized void getTicket() {
        synchronized (lock) {//或者this
            if (ticketNum <= 0) {
                return;
            }
            System.out.println(Thread.currentThread().getName() + "抢到一张票,剩余:" + ticketNum);
            // 非原子性操作
            ticketNum--;
        }
    }

    public static void main(String[] args) {
        A01TicketDemo ticketDemo = new A01TicketDemo();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                ticketDemo.getTicket();
            }).start();
        }
    }


}