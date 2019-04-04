package 门面类模式;

/**
 * <Description>
 * 系统内部子系统，调用Chinese类的任何公共属性和方法
 * @author wangxi
 */
public class InnerSystem {
    public void invokePerson() {
        Chinese chinese = new Chinese("面.");
        chinese.name = "aa";
        chinese.run();
    }
}

