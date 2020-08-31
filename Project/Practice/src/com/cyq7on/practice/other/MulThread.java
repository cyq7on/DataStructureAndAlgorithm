package com.cyq7on.practice.other;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
* @description
 * 滴滴面试题，实现主线程打印world，子线程打印hello，常规的join，标志位，sleep和wait方法不再赘述
* @author cyq7on
* @create 2020/8/31
**/
public class MulThread {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        useCountDownLatch();
        useCyclicBarrie();
    }

    private static void useCountDownLatch() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(() -> {
            System.out.print("Hello ");
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
        System.out.println("World");
    }

    private static void useCyclicBarrie() throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        new Thread(() -> {
            System.out.print("Hello ");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        cyclicBarrier.await();
        System.out.println("World");
    }
}
