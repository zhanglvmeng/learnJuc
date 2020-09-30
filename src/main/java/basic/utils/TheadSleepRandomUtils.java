package basic.utils;

import java.util.Random;

/**
 * @author zhangpeng
 * @Date 2020/9/30
 */
public class TheadSleepRandomUtils {
    private static int DEFAULT_SECONDS = 5;
    private static int SECOND_MILLIS = 1000;

    public static void sleepRandomSecond(int bound) {
        int r = DEFAULT_SECONDS;
        if (bound >= 1) {
            Random random = new Random();
            r = random.nextInt(bound);
        }
        try {
            Thread.sleep(r * SECOND_MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
