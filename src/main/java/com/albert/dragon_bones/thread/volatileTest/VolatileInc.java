package com.albert.dragon_bones.thread.volatileTest;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * Volatile内存可见性测试
 *
 * Created by Albert on 2018/7/18.
 */
public class VolatileInc implements Runnable {
    private static volatile int count = 0;//使用 volatileTest 修饰基本数据内存不能保证原子性
    //    private static volatileTest AtomicInteger count = new AtomicInteger(0);
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            count ++;
//            count.addAndGet(1) ;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileInc volatileInc = new VolatileInc();
        Thread t1 = new Thread(volatileInc, "t1");
        Thread t2 = new Thread(volatileInc, "t2");
        t1.start();
        t2.start();
        for (int i = 0; i < 10000; i++) {
            count ++; //不是原子性操作
//            count.addAndGet(1) ;
        }
        System.out.println("count = " + count);
    }
}