package multithread.code.practice.ch8;

import java.util.concurrent.ThreadFactory;

/**
 * ThreadFactory demo
 * https://lanffy.github.io/2017/05/28/create-thread-by-threadFactory
 * @author zhangpeng
 * @Date 2020/9/3
 */
public class ThreadFactoryDemo {

    public static void main(String[] args) {
        FactoryDemo factoryDemo = new FactoryDemo();
        Thread t = factoryDemo.newThread(new Task());
        t.start();
        System.out.println(t.getName());
        Thread thread = factoryDemo.newThread(new Task());
        System.out.println(thread.getName());
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("Runnable...");
        }
    }

    public static class FactoryDemo implements ThreadFactory {
        private int counter;

        FactoryDemo() {
            counter = 1;
        }
        @Override
        public Thread newThread(Runnable runnable) {
            Thread t = new Thread(runnable, "TestFactory thread_" + counter);
            counter++;
            return t;
        }
    }
}
