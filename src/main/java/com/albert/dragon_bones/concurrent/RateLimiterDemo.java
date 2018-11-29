package com.albert.dragon_bones.concurrent;
 
import com.google.common.util.concurrent.RateLimiter;

/**
 * RateLimiter类似于JDK的信号量Semphore，他用来限制对资源并发访问的线程数。
 * 与Semaphore 相比，Semaphore 限制了并发访问的数量而不是使用速率
 */
public class RateLimiterDemo {
    public static void main(String[] args) {
    	testNoRateLimiter();
    	testWithRateLimiter();
    }
 
    public static void testNoRateLimiter() {
    	Long start = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            System.out.println("call execute.." + i);
            
        }
        Long end = System.currentTimeMillis();
        
        System.out.println(end - start);
        
    }
    
    public static void testWithRateLimiter() {
    	Long start = System.currentTimeMillis();
        RateLimiter limiter = RateLimiter.create(10.0); // 每秒不超过10个任务被提交
        for (int i = 0; i < 20; i++) {
            limiter.acquire(); // 请求RateLimiter, 超过permits会被阻塞
            System.out.println("call execute.." + i);
            
        }
        Long end = System.currentTimeMillis();
        
        System.out.println(end - start);
        
    }
    
}

