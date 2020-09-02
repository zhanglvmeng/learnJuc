package multithread.code.practice.ch3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zhangpeng
 * @Date 2020/8/30
 */
public class AtomicLongDemo {
    private final static AtomicLong atomicLong = new AtomicLong(0);

    public static void main(String[] args) {
        List list1 =new ArrayList();
        list1.add("1111");
        list1.add("2222");
        list1.add("3333");

        List list2 =new ArrayList();
        list2.add("3333");
        list2.add("4444");
        list2.add("5555");

        //并集
        //list1.addAll(list2);
        //交集
        list1.retainAll(list2);
        System.out.println("list1 is " + String.join(",", list1));
        System.out.println("list2 is " + String.join(",", list2));
    }
}
