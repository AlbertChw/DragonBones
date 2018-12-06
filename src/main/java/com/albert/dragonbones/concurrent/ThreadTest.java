package com.albert.dragonbones.concurrent;

/**
 * Created by Albert on 2018/8/8.
 */
public class ThreadTest {
    public static void main(String[] args) {
        Object shareobj = new Object();
        TestThread_Wait thread_wait = new TestThread_Wait(shareobj);
        thread_wait.start();

        TestThread_Notify thread_notify = new TestThread_Notify(shareobj);
        thread_notify.start();
    }
    /*Have notified
    sleep complete
    is notified
    从打印接过来看，lock.notify()执行之后，并没有马上唤醒等待该锁的线程，
    而是该同步块完全执行完之后，等待该锁的线程才被真正的唤醒
    */

}
