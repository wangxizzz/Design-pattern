package 策略模式;

/**
 * @Author:王喜
 * @Description :老客户的报价策略
 * @Date: 2018/4/28 0028 16:43
 */
public class OldCustomerStrategy implements Strategy{

    /**
     * 计算货物的价格
     *
     * @param goodPrice 货物的原价
     * @return 返回应该报给客户的价格
     */
    @Override
    public double calPrice(double goodPrice) {
        System.out.println("对于老客户，打95折");
        return goodPrice*0.95;
    }
}
