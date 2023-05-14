package com.juc.a02lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author eniac555
 * @date 2023/5/13
 * @description: 简单的Lock锁测试
 */
public class A00LockTest {

    static Lock  lock  = new ReentrantLock();

    public static void method1(){
        try{
            lock.lock();
            method2();
        }finally{
            lock.unlock();
        }
    }

    public static void method2(){
        try{
            lock.lock();
        }finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        method1();
    }
}
