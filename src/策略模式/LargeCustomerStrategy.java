package 策略模式;

/**
 * @Author:王喜
 * @Description :大客户报价策略
 * @Date: 2018/4/28 0028 16:44
 */
public class LargeCustomerStrategy implements Strategy{
    /**
     * 计算货物的价格
     *
     * @param goodPrice 货物的原价
     * @return 返回应该报给客户的价格
     */
    @Override
    public double calPrice(double goodPrice) {
        System.out.println("对于大客户，打9折");
        return goodPrice*0.9;
    }
}
