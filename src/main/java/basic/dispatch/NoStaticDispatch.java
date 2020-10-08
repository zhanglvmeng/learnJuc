package basic.dispatch;

/**
 * @author zhangpeng
 * @Date 2020/10/8
 */
public class NoStaticDispatch {

    public void sayHello(Animal animal) {
        System.out.println("Animal say");
    }

    public void sayHello(Dog dog) {
        System.out.println("dog say");
    }

    public void sayHello(Cat cat) {
        System.out.println("cat say");
    }

    public static void main(String[] args) {
        Animal cat = new Cat();

        Animal dog = new Dog();

        Animal animal = new Animal();

        NoStaticDispatch noStaticDispatch = new NoStaticDispatch();

        System.out.println("原来的静态类型 ----");

        noStaticDispatch.sayHello(animal);

        noStaticDispatch.sayHello(cat);

        noStaticDispatch.sayHello(dog);

        System.out.println("静态类型的强转 ----");

        noStaticDispatch.sayHello(animal);

        noStaticDispatch.sayHello((Cat)cat);

        noStaticDispatch.sayHello((Dog)dog);


    }

}
