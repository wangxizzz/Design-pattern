package 监听器模式.用观察者模式重构;

/**
 * <Description>
 *  抽象的监听器(Buyer)
 * @author wangxi
 */
public abstract class Buyer {
    protected String name;
    protected Shop shop;

    public Buyer(String name, Shop shop) {
        this.name = name;
        this.shop = shop;
//        shop.register(this);
    }

    public abstract void inform();
}

