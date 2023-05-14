package com.juc.a01basic;

/**
 * @author eniac555
 * @date 2023/5/13
 * @description: 退出线程：使用stop方法强行终止（不推荐，方法已作废）
 */
public class A09MyInterrupt2 extends Thread {

    volatile boolean flag = false ; // 线程执行的退出标记

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
        A09MyInterrupt2 t1 = new A09MyInterrupt2() ;
        t1.start();

        // 主线程休眠2秒
        Thread.sleep(6000);

        // 调用stop方法
        t1.stop();

    }
}