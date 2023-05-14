package com.juc.a01basic;

/**
 * @author eniac555
 * @date 2023/5/13
 * @description: 退出线程：使用退出标志，使线程正常退出，也就是当run方法完成后线程终止
 */

public class A08MyInterrupt1 extends Thread {

    volatile boolean flag = false ;// 线程执行的退出标记

    @Override
    public void run() {
        while(!flag) {
            System.out.println("MyThread...run...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // 创建MyThread对象
        A08MyInterrupt1 t1 = new A08MyInterrupt1() ;
        t1.start();

        // 主线程休眠6秒
        Thread.sleep(6000);

        // 更改标记为true
        t1.flag = true ;

    }
}