package basic.classloader;

/**
 * @author zhangpeng
 * @Date 2020/10/7
 */
public interface InterfaceTest {

    int i = 5;
    /**
     * abstrace method
     */
    default void test() {
        System.out.println("interface default method");
    }
}
