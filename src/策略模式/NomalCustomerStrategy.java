package 策略模式;

/**
 * @Author:王喜
 * @Description : 给普通用户或者新用户应报的价格策略
 * @Date: 2018/4/28 0028 16:41
 */
public class NomalCustomerStrategy implements Strategy{
    /**
     * 计算货物的价格
     *
     * @param goodPrice 货物的原价
     * @return 返回应该报给客户的价格
     */
    @Override
    public double calPrice(double goodPrice) {
        System.out.println("对于普通或新用户的客户，原价售出");
        return goodPrice;
    }
}
