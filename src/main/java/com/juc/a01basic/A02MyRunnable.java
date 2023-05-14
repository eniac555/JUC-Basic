package com.juc.a01basic;

/**
 * @author eniac555
 * @date 2023/5/13
 * @description: 通过实现Runnable接口创建线程
 */
public class A02MyRunnable implements Runnable {

    @Override
    public void run(){
        System.out.println("MyRunnable...run...");
    }

    public static void main(String[] args) {

        // 创建MyRunnable对象
        A02MyRunnable mr = new A02MyRunnable();

        // 创建Thread对象
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);

        // 调用start方法启动线程
        t1.start();
        t2.start();

    }
}