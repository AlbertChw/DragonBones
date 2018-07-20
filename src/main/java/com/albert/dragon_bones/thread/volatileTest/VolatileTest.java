package com.albert.dragon_bones.thread.volatileTest;

import java.util.concurrent.TimeUnit;

/**
 * Volatile内存可见性测试
 *
 * Created by Albert on 2018/7/18.
 */
public class VolatileTest implements Runnable {

    //当一个变量被 volatileTest 修饰时，任何线程对它的写操作都会立即刷新到主内存中，并且会强制让缓存了该变量的线程中的数据清空，必须从主内存重新读取最新数据。
    //volatileTest 修饰之后并不是让线程直接从主内存中获取数据，依然需要将变量拷贝到工作内存中。
    private static volatile boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            System.out.println(Thread.currentThread().getName() + "     正在运行。。。");
        }
        System.out.println(Thread.currentThread().getName() + "     执行完毕");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        new Thread(volatileTest, "thread A").start();
        System.out.println("main 线程正在运行...");
        TimeUnit.MILLISECONDS.sleep(100);
        volatileTest.stopThread();
    }

    private void stopThread() {
        flag = false;
    }
}