package com.juc.a02lock;

/**
 * @author eniac555
 * @date 2023/5/13
 * @description: 共享变量（类的成员变量、类的静态成员变量）被volatile修饰之后，那么就具备了两层语义：保证线程间的可见性
 */
public class A03Volatile {
    static volatile boolean stop = false;
    //保证了不同线程对这个变量进行操作时的可见性，
    //即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的, volatile关键字会强制将修改的值立即写入主存。

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stop = true;
            System.out.println(Thread.currentThread().getName() + "：modify stop to true...");
        }, "t1").start();


        new Thread(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "：" + stop);
        }, "t2").start();


        new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
            }
            System.out.println("stopped... c:" + i);
        }, "t3").start();
    }
}
