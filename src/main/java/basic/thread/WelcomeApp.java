package basic.thread;

/**
 * @author zhangpeng
 * @Date 2020/8/29
 */
public class WelcomeApp {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        WelcomeThread welcomeThread = new WelcomeThread();
        welcomeThread.start();

        WelcomeThread2 welcomeThread2 = new WelcomeThread2();
        new Thread(welcomeThread2).start();
    }
}

