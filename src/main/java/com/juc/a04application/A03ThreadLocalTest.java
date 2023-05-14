package com.juc.a04application;

/**
 * @author eniac555
 * @date 2023/5/14
 * @description: ThreadLocal基本使用
 */
public class A03ThreadLocalTest {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            String name = Thread.currentThread().getName();
            threadLocal.set("111");
            print(name);
            System.out.println(name + "-after remove : " + threadLocal.get());
        }, "t1").start();

        new Thread(() -> {
            String name = Thread.currentThread().getName();
            threadLocal.set("222");
            print(name);
            System.out.println(name + "-after remove : " + threadLocal.get());
        }, "t2").start();
    }

    static void print(String str) {
        //打印当前线程中本地内存中本地变量的值
        System.out.println(str + " :" + threadLocal.get());
        //清除本地内存中的本地变量
        threadLocal.remove();
    }

}