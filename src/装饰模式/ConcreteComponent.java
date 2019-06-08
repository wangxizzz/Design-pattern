package 装饰模式;

import java.util.Date;

/**
 * @Author:王喜
 * @Description : 具体的组件实现类
 * @Date: 2018/4/28 0028 15:56
 */
public class ConcreteComponent extends AbstractComponent {

    @Override
    public double calcPrize(String user, Date begin, Date end) {
        //只是一个默认的实现，默认没有奖金,通过装饰器可以算出其他的奖金
        return 0;
    }
}
