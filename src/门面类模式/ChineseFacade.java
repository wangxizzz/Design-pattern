package 门面类模式;

/**
 * <Description>
 *
 * @author wangxi
 */
public class ChineseFacade implements Person{

    private Chinese chinese;

    public ChineseFacade(Chinese chinese) {
        this.chinese = chinese;
    }

    @Override
    public void eat() {
        chinese.eat();
    }
}

