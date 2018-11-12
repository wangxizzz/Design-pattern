package 策略模式;

/**
 * @Author:王喜
 * @Description : 定义计算价格的策略接口
 * @Date: 2018/4/28 0028 16:38
 */
public interface Strategy {

    /**
     * 计算货物的价格
     * @param goodPrice  货物的原价
     * @return  返回应该报给客户的价格
     */
    double calPrice(double goodPrice);
}
