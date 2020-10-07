package basic.safe.publish;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author zhangpeng
 * @Date 2020/10/7
 */
@Slf4j
public class UnsafePublish {
    private String[] states = {"a", "b", "c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        System.out.println(Arrays.toString(unsafePublish.getStates()));

        unsafePublish.getStates()[0] = "d";
        System.out.println(Arrays.toString(unsafePublish.getStates()));
    }
}
