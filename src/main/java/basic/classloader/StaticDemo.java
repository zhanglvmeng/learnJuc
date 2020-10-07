package basic.classloader;

/**
 * @author zhangpeng
 * @Date 2020/10/7
 */
public class StaticDemo {
    public static int count = 0;

    static {
        System.out.println("static demo class run");
    }


    public static void main(String[] args) {
        System.out.println("test begin ....");
//        System.out.println(SubClass.name);
        try {
            Class clz = Class.forName("basic.classloader.SubClass");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

