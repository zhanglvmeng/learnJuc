package multithread.code.practice.ch2;

/**
 * @author zhangpeng
 * @Date 2020/8/30
 */
public class MultiThreadDemo {

    public static void main(String[] args) {
        int processorNum = Runtime.getRuntime().availableProcessors();
        System.out.println(processorNum);
    }
}
