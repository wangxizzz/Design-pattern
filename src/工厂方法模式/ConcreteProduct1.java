package 工厂方法模式;
/**
 * 
 * @ClassName: ConcreteProduct1  
 * @Description: 具体的产品1，继承抽象Product
 * @author 王喜 
 * @date 2018年3月3日 下午9:12:40
 */
public class ConcreteProduct1 extends Product{

	//实现父类的抽象方法
	@Override
	public void method1() {
		System.out.println("获得产品ConcreteProduct1。。。");
	}

}
