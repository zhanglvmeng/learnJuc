package basic.thread;

/**
 * @author zhangpeng
 * @Date 2020/8/30
 */
public class JavaThreadAndwhere {

    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();

        String currentThreadName = currentThread.getName();

        System.out.println(currentThreadName);
        Helper h = new Helper("hello");
        h.run();
        System.out.println("线程状态： " +  currentThread.getState());
    }

    static class Helper implements Runnable {

        private final String message;

        public Helper(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            doSomething(this.message);
        }

        private void doSomething(String message) {
            Thread currentThead = new Thread();
            String currentThreadName = currentThead.getName();
            System.out.println("do some thing " + currentThreadName);
            System.out.println("message: " + message);

        }
    }
}


