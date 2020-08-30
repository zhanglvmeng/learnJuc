package multithread.code.practice.ch3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangpeng
 * @Date 2020/8/30
 */
public class LockDemo {
    private static final Lock lock = new ReentrantLock();
    private static int sharedData = 0;

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    Thread.sleep(2200000);
                    sharedData = 1;
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        });
        t.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        try {
            System.out.println("sharedData: " + sharedData);
        } finally {
            lock.unlock();
        }
    }
}
