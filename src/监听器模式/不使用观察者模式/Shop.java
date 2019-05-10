package 监听器模式.不使用观察者模式;

/**
 * <Description>
 *  商店
 * @author wangxi
 */
public class Shop {
    private String product;
    // 初始商店无商品
    public Shop() {
        this.product = "无商品";
    }
    //商店出货
    public String getProduct() {
        return product;
    }
    //商店进货
    public void setProduct(String product) {
        this.product = product;
    }
}

