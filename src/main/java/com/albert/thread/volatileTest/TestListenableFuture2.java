package com.albert.thread.volatileTest;

import com.google.common.util.concurrent.*;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class TestListenableFuture2 {
    // 创建线程池
    final static ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

    public static void moreThread() {
        try {
            int threadNum = 0;
            for (int i = 0; i < 10; i++) {
                threadNum++;

                final int currentThreadNum = threadNum;
                service.execute(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            System.out.println("子线程[" + currentThreadNum + "]开启");
                            Thread.sleep(1000*10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally{
                            System.out.println("子线程[" + currentThreadNum + "]结束");
                        }
                    }
                });
            }

            System.out.println("已经开启所有的子线程");
            service.shutdown();
            System.out.println("shutdown()：启动一次顺序关闭，执行以前提交的任务，但不接受新任务。");
            while(true){
                if(service.isTerminated()){
                    System.out.println("所有的子线程都结束了！");
                    break;
                }
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            System.out.println("主线程结束");
        }

        System.out.println("================");

        int threadNum = 0;

        for (int i = 0; i < 10; i++) {
            threadNum++;

            final int currentThreadNum = threadNum;
            service.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        System.out.println("子线程[" + currentThreadNum + "]开启");
                        Thread.sleep(1000*10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally{
                        System.out.println("子线程[" + currentThreadNum + "]结束");
                    }
                }
            });
        }

    }

    public static void main(String[] args) throws Exception {

        moreThread();
    }
}