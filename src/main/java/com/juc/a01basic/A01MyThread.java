package com.juc.a01basic;

/**
 * @author eniac555
 * @date 2023/5/13
 * @description: 通过继承Thread类创建线程
 */
public class A01MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread...run...");
    }

    public static void main(String[] args) {
        //创建Thread对象
        A01MyThread t1 = new A01MyThread();
        A01MyThread t2 = new A01MyThread();

        // 调用start方法启动线程
        t1.start();
        t2.start();
    }
}
