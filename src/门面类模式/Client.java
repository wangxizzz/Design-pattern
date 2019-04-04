package 门面类模式;

/**
 * <Description>
 * 系统外部测试
 * @author wangxi
 */
public class Client {
    public static void main(String[] args) {
        /**
         * 在系统外部，我不希望别人看到Chinese中的run()方法，
         * 但是我又不能设置为private或者包可见,因为在系统内部需要调用run()，
         * 因此可以采用门面模式隐藏内部的方法
         */
        ChineseFacade chineseFacade = new ChineseFacade(new Chinese("饭..."));
        chineseFacade.eat();

    }
}

