package 工厂方法模式;
/**
 * 
 * @ClassName: Client  
 * @Description: 客户端得到具体的产品
 * @author 王喜 
 * @date 2018年3月3日 下午9:27:20
 */
public class Client {

	public static void main(String[] args) {
		/**
		 * 多态的体现
		 */
		AbstractFactory concreteFactory = new ConcreteFactory();
		//通过工厂生产出产品1
		Product product = concreteFactory.createProduct(ConcreteProduct1.class);
		product.method1();
		//通过静态工厂生产出产品2
		product = StaticFactory.createProduct(ConcreteProduct2.class);
		product.method1();
	}

}
