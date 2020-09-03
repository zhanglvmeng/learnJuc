package multithread.code.practice.ch5;

import java.util.concurrent.ThreadFactory;

/**
 * @author zhangpeng
 * @Date 2020/9/2
 */
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("thread run begin");
                String s = null;
                s.substring(1,2);
                System.out.println("thread run end");
            }
        };
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.setName("testThread");
        thread.start();

    }

    private static class ExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName());
            System.out.println(e);
        }

    }

}
