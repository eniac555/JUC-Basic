package com.juc.a01basic;

import static com.juc.a01basic.LoggerUtils.get;
import static com.juc.a01basic.LoggerUtils.main;

/**
 * @author eniac555
 * @date 2023/5/13
 * @description: 测试wait 和 sleep 方法的不同
 */
public class A07WaitSleepCase {

    static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        sleeping();
    }


    private static void illegalWait() throws InterruptedException {
        LOCK.wait();
    }

    private static void waiting() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (LOCK) {
                try {
                    get("t").debug("waiting...");
                    LOCK.wait(5000L);
                    get("t").debug("running...end...");
                } catch (InterruptedException e) {
                    get("t").debug("interrupted...");
                    e.printStackTrace();
                }
            }
        }, "t1");

        t1.start();

        Thread.sleep(100);
        synchronized (LOCK) {
            main.debug("other...");
        }

    }


    private static void sleeping() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (LOCK) {
                try {
                    get("t").debug("sleeping...");
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    get("t").debug("interrupted...");
                    e.printStackTrace();
                }
            }
        }, "t1");

        t1.start();

        Thread.sleep(100);
        synchronized (LOCK) {
            main.debug("other...");
        }
    }


}
