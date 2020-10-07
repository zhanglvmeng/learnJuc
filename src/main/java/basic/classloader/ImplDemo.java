package basic.classloader;

/**
 * @author zhangpeng
 * @Date 2020/10/7
 */
public class ImplDemo implements InterfaceTest {

    static {
        System.out.println("impl static code ");
    }

    public static void main(String[] args) {
        System.out.println("impl begin");
        System.out.println(ImplDemo.i);
    }
}
