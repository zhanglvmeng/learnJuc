package basic.threadlocaldemo;

/**
 *
 * @ClassName:MyThreadLocal
 * @Description:ThreadLocal线程本地变量
 * @author diandian.zhang
 * @date 2017年12月4日上午9:40:52
 */
public class MyThreadLocal2 {
    //线程本地共享变量
    private static final ThreadLocal<Integer> intThreadLocal = new ThreadLocal<Integer>(){
        /**
         * ThreadLocal没有被当前线程赋值时或当前线程刚调用remove方法后调用get方法，返回此方法值
         */
        @Override
        protected Integer initialValue()
        {
            return 0;
        }
    };

    //线程本地共享变量
    private static final ThreadLocal<String> stringThreadLocal = new ThreadLocal<String>(){
        /**
         * ThreadLocal没有被当前线程赋值时或当前线程刚调用remove方法后调用get方法，返回此方法值
         */
        @Override
        protected String initialValue()
        {
            return "";
        }
    };



    public static void main(String[] args){

        MyThreadLocal2.intThreadLocal.set(1);
        MyThreadLocal2.stringThreadLocal.set("name");

        System.out.println(MyThreadLocal2.intThreadLocal.get());
        System.out.println(MyThreadLocal2.stringThreadLocal.get());

    }

}
