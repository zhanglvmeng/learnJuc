package multithread.code.practice.ch8;

import java.util.concurrent.*;

/**
 * @author zhangpeng
 * @Date 2020/9/3
 */
public class ThreadPoolDemo {

    final static int N_CPU = Runtime.getRuntime().availableProcessors();
    final static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            0,
            N_CPU * 2,
            4,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(20),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {
        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();
        Future<String> future = recognizeFuture("file");
        try {
            String result = future.get(10 * 1000, TimeUnit.MILLISECONDS);
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("interrupt exception");
        } catch (ExecutionException e) {
            e.printStackTrace();
            System.out.println("execution exception");
        } catch (TimeoutException e) {
            e.printStackTrace();
            System.out.println("time out exception");
        }

    }

    private static String doSomething() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "do something...";
    }

    private static Future<String> recognizeFuture(String file) {
        return threadPoolExecutor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return doSomething();
            }
        });
    }


}
