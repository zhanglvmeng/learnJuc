package multithread.code.practice.ch8;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangpeng
 * @Date 2020/9/3
 */
public class ThreadPoolDemo {

    final static int N_CPU = Runtime.getRuntime().availableProcessors();
    final static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                       20,
                       4,
                       TimeUnit.MINUTES,
                       new ArrayBlockingQueue<>(20),
                       new FactoryDemo("zp test "),
                       new ThreadPoolExecutor.CallerRunsPolicy());


    public static void main(String[] args) {
        try {
            String s = null;
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

////        System.out.println("cpu count : " + N_CPU);
//        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();
//        int threadCount = 0;
//        try {
//            Future future = recognizeFuture(++threadCount);
//            Future future2 = recognizeFuture(++threadCount);
//            // 是否取消
////            future.cancel(true);
////            System.out.println("cancel is ok ? " + future.isCancelled());
////            monitorPool(threadPoolExecutor);
//            Thread.sleep(2000);
//            future.get(10 * 1000, TimeUnit.MILLISECONDS);
//
//            System.out.println("------------- 分割线 ------------- ");
//            // 是否取消
////            future.cancel(true);
////            System.out.println("cancel is ok ? " + future.isCancelled());
////            monitorPool(threadPoolExecutor);
//            future2.get(10 * 1000, TimeUnit.MILLISECONDS);
//            System.out.println("结束了");
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            System.out.println("interrupt exception");
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//            System.out.println("execution exception");
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//            System.out.println("time out exception");
//        }


    }

    private static void doSomething(int count) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread " + count + " is doing something...");
    }

    private  static Future<?> recognizeFuture(int threadCount) {
        return threadPoolExecutor.submit(new TaskRunnable(threadCount));
    }

    /**
     * 线程池监控
     * @param threadPoolExecutor
     */
    private static void monitorPool(ThreadPoolExecutor threadPoolExecutor) {
        System.out.println("========== monitor begin ==========");
        System.out.println("pool size : " + threadPoolExecutor.getPoolSize());
        System.out.println("queue size: " + threadPoolExecutor.getQueue().size());
        System.out.println("largest pool size : " + threadPoolExecutor.getLargestPoolSize());
        System.out.println("========== monitor end ==========");
    }

    static class TaskRunnable implements Runnable {
        private int counter;
        TaskRunnable(int counter) {
            this.counter = counter;
        }
        @Override
        public void run() {
            doSomething(counter);
        }
    }

    /**
     * 线程池 线程工厂类
     */
    public static class FactoryDemo implements ThreadFactory {
        private final AtomicInteger counter = new AtomicInteger(1);
        private String name;
        FactoryDemo(String name) {
            this.name = name;
        }
        @Override
        public Thread newThread(Runnable runnable) {
            Thread t = new Thread(runnable, name + "TestFactory thread_" + counter);
            counter.getAndIncrement();
            System.out.println("thread name is " + t.getName());
            return t;
        }

    }

}
