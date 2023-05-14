package com.juc.a01basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author eniac555
 * @date 2023/5/13
 * @description: 通过实现Callable接口创建线程
 */
public class A03MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return "ok";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建MyCallable对象
        A03MyCallable mc = new A03MyCallable() ;
        // 创建FutureTask
        FutureTask<String> ft = new FutureTask<>(mc) ;
        // 创建Thread对象
        Thread t1 = new Thread(ft) ;
        Thread t2 = new Thread(ft) ;
        // 调用start方法启动线程
        t1.start();
        // 调用ft的get方法获取执行结果
        String result = ft.get();
        // 输出
        System.out.println(result);
    }
}