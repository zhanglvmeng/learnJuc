package lockbadcase.sync;

/**
 * @author zhangpeng
 * @Date 2020/11/5
 */
public class MyThread implements Runnable  {
    private Demo demo;

    public MyThread(Demo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        demo.demo();
    }
}
