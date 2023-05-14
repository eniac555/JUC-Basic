package com.juc.a01basic;

/**
 * @author eniac555
 * @date 2023/5/13
 * @description: 测试新建线程
 */
public class NewThread {

    private static class UseThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": use thread");
        }
    }

    private static class UseRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": use runnable");
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+": use main");

        UseThread useThread = new UseThread();
        useThread.start();

        Thread thread = new Thread(new UseRunnable());
        thread.start();

    }

}

