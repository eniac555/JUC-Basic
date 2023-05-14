package com.juc.a01basic;

/**
 * @author eniac555
 * @date 2023/5/13
 * @description: T1、T2、T3 三个线程，保证它们按顺序执行
 */
public class A05JoinTest {

    public static void main(String[] args) throws InterruptedException {

        // 创建线程对象
        Thread t1 = new Thread(() -> {
            System.out.println("t1");
        }) ;
        Thread t2 = new Thread(() -> {
            try {
                t1.join();// 加入线程t1,只有t1线程执行完毕以后，再次执行该线程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2");
        }) ;
        Thread t3 = new Thread(() -> {
            try {
                t2.join();// 加入线程t2,只有t2线程执行完毕以后，再次执行该线程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3");
        }) ;
        // 启动线程  无论启动哪一个都是一样的运行顺序
        t3.start();
        t2.start();
        t1.start();

    }

}