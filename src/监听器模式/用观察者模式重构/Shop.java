package 监听器模式.用观察者模式重构;

import java.util.ArrayList;
import java.util.List;

/**
 * <Description>
 *
 * @author wangxi
 */
public class Shop {
    private String product;
    private List<Buyer> buyers;  // 持有买家的引用

    public Shop() {
        this.product = "无商品";
        this.buyers = new ArrayList<>();
    }

    // 为了主动通知买家，买家得来店里注册。
    public void register(Buyer buyer) {
        this.buyers.add(buyer);
    }

    public String getProduct() {
        return product;
    }
    // 进货
    public void setProduct(String product) {
        this.product = product;  // 进货商品
        notifyBuyers();// 到货后通知买家
    }
    // 通知所有注册买家
    private void notifyBuyers() {
        buyers.forEach(Buyer::inform);
    }

}

