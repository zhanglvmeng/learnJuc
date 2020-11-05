package lockbadcase.sync;

/**
 * @author zhangpeng
 * @Date 2020/11/5
 */
public class Demo {

    public synchronized void demo(){
        while (true) {
            System.out.println(Thread.currentThread());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized static void demo2() {
        while (true) {
            System.out.println(Thread.currentThread());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
