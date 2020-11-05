package lockbadcase.sync;

/**
 * @author zhangpeng
 * @Date 2020/11/5
 */
public class MyThreadInvokeStatic implements Runnable  {
    private Demo demo;

    public MyThreadInvokeStatic(Demo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        Demo.demo2();
    }
}
