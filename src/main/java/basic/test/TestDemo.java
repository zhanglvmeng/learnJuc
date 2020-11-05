package basic.test;

import java.time.LocalDate;
import java.time.ZoneOffset;

/**
 * @author zhangpeng
 * @Date 2020/10/14
 */
public class TestDemo {

    public static void main(String[] args) {
        System.out.println(LocalDate.now().atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli());
    }
}
