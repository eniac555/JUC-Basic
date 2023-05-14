package com.juc.a02lock;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

public class TestPhantomReference {

    public static void main(String[] args) throws InterruptedException {

        ReferenceQueue<String> queue = new ReferenceQueue<>();
        List<MyResource> list = new ArrayList<>();
        list.add(new MyResource(new String("a"),queue));
        list.add(new MyResource("b",queue));
        list.add(new MyResource(new String("c"),queue));

        System.gc();

        Thread.sleep(100);

        Object ref ;
        while ((ref =queue.poll()) != null){
            if(ref instanceof MyResource){
                MyResource.clean();
            }
        }

    }

    static class MyResource extends PhantomReference<String> {

        public MyResource(String referent, ReferenceQueue<? super  String> q){
            super(referent,q);
        }

        //释放外部资源的方法
        public static void clean(){
            System.out.println("clean");
        }
    }
}
