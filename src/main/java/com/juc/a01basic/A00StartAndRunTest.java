package com.juc.a01basic;

/**
 * @author eniac555
 * @date 2023/5/13
 * @description: 测试run方法和start方法的不同
 */

public class A00StartAndRunTest {

    public static void main(String[] args) {

        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                System.out.println("running....");
            }
        };
        //t1.run();
        //t1.run();
        //t1.run();
        t1.start();
        t1.start();
        t1.start();
    }
}
