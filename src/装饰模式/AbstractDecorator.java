package 装饰模式;

import java.util.Date;

/**
 * @Author:王喜
 * @Description : 装饰器的接口，需要跟被装饰的对象实现同样的接口
 * @Date: 2018/4/28 0028 15:58
 */
public abstract class AbstractDecorator extends AbstractComponent {

    private AbstractComponent c;
    public AbstractDecorator(AbstractComponent c) {
        this.c = c;
    }


    @Override
    public double calcPrize(String user, Date begin, Date end) {
        return c.calcPrize(user, begin, end);
    }
}
