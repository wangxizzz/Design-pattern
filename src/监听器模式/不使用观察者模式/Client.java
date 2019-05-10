package 监听器模式.不使用观察者模式;

/**
 * <Description>
 *
 * @author wangxi
 */
public class Client {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Buyer wukong = new Buyer("悟空", shop);
        Buyer shaseng = new Buyer("沙僧", shop);
        Buyer bajie = new Buyer("八戒", shop);

        wukong.buy();// 悟空购买：无商品
        bajie.buy();// 八戒购买：无商品
        shaseng.buy();// 沙僧购买：无商品
        bajie.buy();// 八戒购买：无商品

        // 师傅忍不住了，也加入了购买行列。
        Buyer tangseng = new Buyer("唐僧", shop);
        tangseng.buy();// 唐僧购买：无商品

        // 除了八戒其他人都放弃了
        bajie.buy();// 八戒购买：无商品
        bajie.buy();// 八戒购买：无商品

        // 商店终于进货了
        shop.setProduct("最新旗舰手机");
        bajie.buy();// 八戒购买：最新旗舰手机
    }
}

