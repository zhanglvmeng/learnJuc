package basic.countdownlatch;

import basic.utils.TheadSleepRandomUtils;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhangpeng
 * @Date 2020/9/30
 */
public class CountDownLatchDemo {
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    /**
     * Account 线程，等待员工到达开会, 进行记录会议
     */
    static class AccountThread extends Thread {
        @Override
        public void run() {
            System.out.println("Account 在会议室等待，需要等" + countDownLatch.getCount() + "个人到来之后进行开会...");
            try {
                //会计等待
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("规定人数都已经到齐了，会计开始记录。。。。");
            TheadSleepRandomUtils.sleepRandomSecond(5);
        }
    }

    /**
     * Boss线程，等待员工到达开会
     */
    static class BossThread extends Thread{
        @Override
        public void run() {
            System.out.println("Boss在会议室等待，总共有" + countDownLatch.getCount() + "个人开会...");
            try {
                //Boss等待
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("规定人数都已经到齐了，开会吧...后面再来的就迟到了，罚款50元");
            TheadSleepRandomUtils.sleepRandomSecond(5);
        }
    }

    /**
     * 员工到达会议室
     */
    static class EmpleoyeeThread  extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "，到达会议室....");
            //员工到达会议室 count - 1
            countDownLatch.countDown();
            System.out.println("countDownLatch count is " + countDownLatch.getCount());
            TheadSleepRandomUtils.sleepRandomSecond(5);
        }
    }

    public static void main(String[] args){
        //Boss线程启动
        new BossThread().start();
        // 会计线程启动
        new AccountThread().start();

        for(long i = 0,j = countDownLatch.getCount() ; i < j ; i++){
            new EmpleoyeeThread().start();
            TheadSleepRandomUtils.sleepRandomSecond(5);
        }
        TheadSleepRandomUtils.sleepRandomSecond(5);
        System.out.println("又来了一个员工，这个员工迟到了");
        new EmpleoyeeThread().start();

    }

}
