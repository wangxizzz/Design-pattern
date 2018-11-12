package 装饰模式;

import java.util.Date;

/**
 * @Author:王喜
 * @Description :装饰器对象，计算当月业务奖金
 * @Date: 2018/4/28 0028 16:06
 */
public class MonthPrizeDecorator extends AbstractDecorator{

    public MonthPrizeDecorator(AbstractComponent c) {
        super(c);
    }

    @Override
    public double calcPrize(String user, Date begin, Date end) {
        //1：先获取前面运算出来的奖金
        double money = super.calcPrize(user, begin, end);
        //2：然后计算当月业务奖金,按照人员和时间去获取当月的业务额，然后再乘以3%
        double prize = TempDB.map.get(user) * 0.03;
        System.out.println(user+"当月业务奖金"+prize);
        return money + prize;
    }
}
