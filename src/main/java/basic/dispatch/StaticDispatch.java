package basic.dispatch;

/**
 * @author zhangpeng
 * @Date 2020/10/8
 */
public class StaticDispatch {

    static abstract class Human {}

    static  class Man extends Human  {}

    static  class Woman extends Human {}

    public void sayHello(Human guy) {
        System.out.println("hello guy");
    }

    public void sayHello(Man guy) {
        System.out.println("hello man");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello woman");
    }

    public static void main(String[] args) {
        Human man = new Man();

        Human woman = new Woman();

        StaticDispatch staticDispatch = new StaticDispatch();

        staticDispatch.sayHello(man);

        staticDispatch.sayHello(woman);
    }

}
