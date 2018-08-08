package com.albert.dragon_bones.concurrent;

/**
 * Created by Albert on 2018/8/8.
 */
public class TestThread_Wait extends Thread {
    Object lock = null;

    public TestThread_Wait(Object lock) {
        this.lock = lock;
        this.setName(this.getClass().getName());
    }

    public void run() {
        fun();
    }

    private void fun()  {
        synchronized (lock) {
            try {
                lock.wait();//wait 会使持有对象锁的线程释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("is notified");
        }
    }
}
