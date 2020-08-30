package basic.demo;

/**
 * @author zhangpeng
 * @Date 2020/8/27
 */
public class TestDemo {

    static long count = 0;

    private void add10K() {
        int idx = 0;
        synchronized (TestDemo.class) {
            while (idx++ < 10000) {
                count += 1;
            }
        }
    }

    public static long calc() {

        try {
            TestDemo test = new TestDemo();
            Thread th1 = new Thread(() -> {
                test.add10K();
            });

            Thread th2 = new Thread(() -> {
                test.add10K();
            });

            th1.start();
            th2.start();

            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(calc());
    }



}
