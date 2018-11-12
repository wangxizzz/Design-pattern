package 策略模式;

/**
 * @Author:王喜
 * @Description :价格管理，主要计算向客户所报价格的功能
 * @Date: 2018/4/28 0028 16:45
 */
public class Price {
    private Strategy strategy;

    public Price(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 计算对客户的报价
     * @param goodPrice 货物原有的价格
     * @return  返回实际需要报给客户的价格
     */
    public double qoute(double goodPrice) {
        return this.strategy.calPrice(goodPrice);
    }
}
