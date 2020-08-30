package multithread.code.practice.ch2;

/**
 * 可见性。
 * 父进程的变量一定先于子进程的start
 * @author zhangpeng
 * @Date 2020/8/30
 */
public class VisibleTheadStartDemo {
    static int data = 0;

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("before sleep: " + data);  // 一定是1
                sleepRandomTimes();
                System.out.println("after sleep: " +data);  // 随机是1 或者 2
            }
        };

        data = 1;
        thread.start();
        sleepRandomTimes();
        data = 2;
    }

    public static void sleepRandomTimes() {
        int sleepTime = (int) (1 + Math.random() * (50 - 1));
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
