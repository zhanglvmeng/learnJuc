package multithread.code.practice.ch5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangpeng
 * @Date 2020/9/2
 */
public class CountDownLatchDemo {

    /**
     * @param args 参数
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        final CountDownLatch latch = new CountDownLatch(4);

        System.out.println("主线程，"+Thread.currentThread().getName()+"执行到这里,分成4个线程执行");

        Runnable runnable0 = () -> {
            try {
                System.out.println("子线程"+Thread.currentThread().getName()+"开始执行");
                Thread.sleep(10000);
                System.out.println("子线程"+Thread.currentThread().getName()+"执行结束");
                // 当前线程调用此方法，则计数减一
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        executorService.execute(runnable0);

        Runnable runnable1 = () -> {
            try {
                System.out.println("子线程"+Thread.currentThread().getName()+"开始执行");
                Thread.sleep(11000);
                System.out.println("子线程"+Thread.currentThread().getName()+"执行结束");
                // 当前线程调用此方法，则计数减一
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        executorService.execute(runnable1);

        Runnable runnable2 = () -> {
            try {
                System.out.println("子线程"+Thread.currentThread().getName()+"开始执行");
                Thread.sleep(12000);
                System.out.println("子线程"+Thread.currentThread().getName()+"执行结束");
                // 当前线程调用此方法，则计数减一
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        executorService.execute(runnable2);

        Runnable runnable3 = () -> {
            try {
                System.out.println("子线程"+Thread.currentThread().getName()+"开始执行");
                Thread.sleep(13000);
                System.out.println("子线程"+Thread.currentThread().getName()+"执行结束");
                // 当前线程调用此方法，则计数减一
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        executorService.execute(runnable3);

        System.out.println("主线程"+Thread.currentThread().getName()+"等待子线程执行完成");
        //阻塞当前线程，直到计数器的值为0
        latch.await();
        System.out.println("主线程"+Thread.currentThread().getName()+"开始执行排序...");
    }


}
