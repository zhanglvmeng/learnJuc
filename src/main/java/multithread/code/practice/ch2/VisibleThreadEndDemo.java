package multithread.code.practice.ch2;

import static multithread.code.practice.ch2.VisibleTheadStartDemo.sleepRandomTimes;

/**
 * 可见性，父进程的join ，一定晚于子进程中的变量
 *
 * @author zhangpeng
 * @Date 2020/8/30
 */
public class VisibleThreadEndDemo {
    static int data = 0;

    public static void main(String[] args) {
        System.out.println("before join: " + data);
        Thread thread = new Thread() {
            @Override
            public void run() {
                sleepRandomTimes();
                data = 1;
            }
        };
        thread.start();

        try {
            // 等子线程结束后，main线程才继续运行。
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 一定是1
        System.out.println("after join: " + data);
    }




}
