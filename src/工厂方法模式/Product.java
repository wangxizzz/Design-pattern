package 工厂方法模式;
/**
 * 
 * @ClassName: Product  
 * @Description:首先创造一个抽象产品类 
 * @author 王喜 
 * @date 2018年3月3日 下午9:08:36
 */
public abstract class Product {
	//子类需要实现的方法
	public abstract void method1();
	
	//子类公有的方法
	public void method2() {
		//业务的书写
	}
}
