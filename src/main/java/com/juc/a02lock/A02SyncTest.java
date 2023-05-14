package com.juc.a02lock;

/**
 * @author eniac555
 * @date 2023/5/13
 * @description: Monitor
 */
public class A02SyncTest {
    static final Object lock = new Object();
    static int counter = 0;
    public static void main(String[] args) {
        synchronized (lock) {
            counter++;
        }
    }
}
