package 监听器模式.用观察者模式重构;

/**
 * <Description>
 *  剁手党买家,只要有商品就买
 * @author wangxi
 */
public class HandChopper extends Buyer{
    public HandChopper(String name, Shop shop) {
        super(name, shop);
    }

    @Override
    public void inform() {
        System.out.print(name);
        String product = shop.getProduct();
        System.out.println("购买：" + product);
    }
}

