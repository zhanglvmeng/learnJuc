package basic.thread;

/**
 * @author zhangpeng
 * @Date 2020/8/29
 */
public class WelcomeThread extends Thread {

    @Override
    public void run() {
        System.out.println("welcome to this world , thread");
        System.out.println(Thread.currentThread());
    }

}
