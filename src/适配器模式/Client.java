package 适配器模式;

/**
 * @Author:王喜
 * @Description :使用适配器的客户端
 * @Date: 2018/4/28 0028 16:22
 */
public class Client {
    public static void main(String[] args) {
        //创建需被适配的对象
        Adaptee adaptee = new Adaptee();        //创建客户端需要调用的接口对象
        Target target = new Adapter(adaptee);        //请求处理
        target.request();
    }
}
