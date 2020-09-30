package com.zp.synchronizeddemo;

import org.openjdk.jol.info.ClassLayout;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.function.IntBinaryOperator;

/**
 *  参考文献：
 *  http://cmsblogs.com/?p=2071
 *  https://www.cnblogs.com/LemonFive/p/11246086.html
 */
public class Main {

    private final int[] arr;

    Main() {
        this.arr = new int[]{1,2,3};
    }

    private final static AtomicIntegerArray ATOMIC_INTEGER_ARRAY = new AtomicIntegerArray(new int[]{1,2,3,4,5,6,7,8,9,10});

    public static void main(String[] args) throws Exception {
//        int i = 1;
//        if (i >=1 && i <= 1) {
//            System.out.println(true);
//        }
        Random random = new Random();
        System.out.println(random.nextInt(-1));
    }

    /**
     * 无锁的状态
     */
    private static void noLock() {
        System.out.println("juc gogogo~");
        A a = new A();
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }

    /**
     * 偏向锁  没有偏向任何线程
     */
    private static void biasedToNothing() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        A a = new A();
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }

    /**
     * 偏向锁  偏向主线程
     */
    private static void biasedToMain() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        A a = new A();
        synchronized (a){
            System.out.println(ClassLayout.parseInstance(a).toPrintable());
        }
    }

    /**
     * 轻量级锁
     */
    private static void lightLock() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        A a = new A();
        try {

            Thread thread1= new Thread(){
                @Override
                public void run() {
                    synchronized (a){
                        System.out.println("thread1 locking");
                        System.out.println(ClassLayout.parseInstance(a).toPrintable()); //偏向锁
                    }
                }
            };

            thread1.start();
            thread1.join();
            Thread.sleep(10000);

            synchronized (a){
                System.out.println("main locking");
                // 轻量锁
                System.out.println(ClassLayout.parseInstance(a).toPrintable());
            }
        } catch (Exception e) {

        }

    }

    /**
     * 重量级锁
     */
    private static void weightLock() {
        try {
            Thread.sleep(5000);
            A a = new A();
            Thread thread1 = new Thread(){
                @Override
                public void run() {
                    synchronized (a){
                        System.out.println("thread1 locking");
                        System.out.println(ClassLayout.parseInstance(a).toPrintable());
                        try {
                            //让线程晚点儿死亡，造成锁的竞争
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            Thread thread2 = new Thread(){
                @Override
                public void run() {
                    synchronized (a){
                        System.out.println("thread2 locking");
                        System.out.println(ClassLayout.parseInstance(a).toPrintable());
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            thread1.start();
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
