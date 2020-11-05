package lockbadcase.sync;

/**
 * @author zhangpeng
 * @Date 2020/11/5
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.method1();
//        main.method2();
//        main.method3();
    }


    private void method1() {
        Demo demo = new Demo();
        Thread thread1 = new Thread(new MyThread(demo), "thread 1");
        Thread thread2 = new Thread(new MyThread(demo), "thread 2");
        thread1.start();
        thread2.start();
    }

    private void method2() {
        Demo demo = new Demo();
        Demo demo2 = new Demo();
        Thread thread1 = new Thread(new MyThread(demo), "thread 1");
        Thread thread2 = new Thread(new MyThread(demo2), "thread 2");
        thread1.start();
        thread2.start();
    }

    /**
     * 静态类
     */
    private void method3() {
        Demo demo = new Demo();
        Demo demo2 = new Demo();
        Thread thread1 = new Thread(new MyThreadInvokeStatic(demo), "thread 1");
        Thread thread2 = new Thread(new MyThreadInvokeStatic(demo2), "thread 2");
        thread1.start();
        thread2.start();
    }


}
