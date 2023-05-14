package com.juc.a03threadpool;

/**
 * @author eniac555
 * @date 2023/5/14
 * @description: 查看本机处理器信息
 */
public class A02ProcessorsDemo {

    public static void main(String[] args) {
        System.out.println("本机CPU内核数如下：");
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
