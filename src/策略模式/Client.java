package 策略模式;

/**
 * @Author:王喜
 * @Description :
 * @Date: 2018/4/28 0028 16:48
 */
public class Client {
    public static void main(String[] args) {
        //创建并使用具体的策略对象
        Strategy strategy = new LargeCustomerStrategy();
        //创建上下文
        Price price = new Price(strategy);
        //计算实际的报价
        System.out.println("大客户的实际价格是：" + price.qoute(10000));
    }
}
