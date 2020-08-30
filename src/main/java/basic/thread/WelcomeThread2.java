package basic.thread;

/**
 * @author zhangpeng
 * @Date 2020/8/29
 */
public class WelcomeThread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("welcome to this world , thread 2");
        System.out.println(Thread.currentThread());
    }

}
