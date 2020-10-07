package basic.safe.publish;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangpeng
 * @Date 2020/10/7
 */
@Slf4j
public class EscapeDemo {

    private int thisCanBeEscape = 0;

    public EscapeDemo() {
        log.info("{}", "hello EscapeDemo ");
        thisCanBeEscape = 1;
        new InnerClass();
    }

    private class InnerClass {
        public InnerClass() {
            log.info("{}", EscapeDemo.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new EscapeDemo();
    }
}
