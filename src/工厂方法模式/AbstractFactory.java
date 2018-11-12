package 工厂方法模式;
/**
 * 
 * @ClassName: AbstractFactory  
 * @Description:  创建一个抽象工厂,作为具体工厂的父类
 * @author 王喜 
 * @date 2018年3月3日 下午9:21:39
 */
public abstract class AbstractFactory {
	
	public abstract <T extends Product> T createProduct(Class<T> c); 
}
