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
		ConcreteFactory concreteFactory = new ConcreteFactory();
		//通过工厂生产出产品1
		ConcreteProduct1 concreteProduct1 = concreteFactory.createProduct(ConcreteProduct1.class);
		concreteProduct1.method1();
		//通过静态工厂生产出产品2
		ConcreteProduct2 concreteProduct2 = StaticFactory.createProduct(ConcreteProduct2.class);
		concreteProduct2.method1();
	}

}
