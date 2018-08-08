package com.albert.dragon_bones.concurrent;

/**
 * Created by Albert on 2018/8/8.
 */
public class TestThread_Notify extends Thread {
    Object lock = null;

    public TestThread_Notify(Object lock) {
        this.lock = lock;
        this.setName(this.getClass().getName());
    }
    public void run() {
        fun();
    }

    private void fun() {
        synchronized (lock) {
            lock.notify();//notify() notifyAll() 等待该锁的线程虽然被唤醒，但是仍无法获得obj锁。直到当前线程退出synchronized块，释放obj锁后，等待该锁的线程中的一个才有机会获得锁
            System.out.println("Have notified");
            try {
                Thread.sleep(2000);//继续占有锁，
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sleep complete");
        }
    }
}
