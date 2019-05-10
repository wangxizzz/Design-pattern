package 监听器模式.不使用观察者模式;

/**
 * <Description>
 *  买家
 * @author wangxi
 */
public class Buyer {
    /**
     * 注意第3行买家持有商店的引用，用来在第10行的购买行为中获取商品，最后是客户端类来模拟买家与商家的互动。
     */
    private String name;// 买家姓名
    private Shop shop;// 商店引用
    public Buyer(String name, Shop shop) {
        this.name = name;
        this.shop = shop;
    }

    public void buy() {// 买家购买商品
        System.out.print(name + "购买：");
        System.out.println(shop.getProduct());
    }
}

