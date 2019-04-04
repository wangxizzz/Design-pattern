package 门面类模式;

/**
 * <Description>
 *
 * @author wangxi
 */
public class Chinese implements Person{
    public String name;

    public String food;

    Chinese(String food) {
        this.food = food;
    }

    @Override
    public void eat() {
        System.out.println("中国人吃：" + food);
    }

    public void run() {
        System.out.println("走路...");
    }
}

