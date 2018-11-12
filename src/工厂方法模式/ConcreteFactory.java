package 工厂方法模式;

/**
 * 
 * @ClassName: ConcreteFactory  
 * @Description: 创建一个实例工厂，生产出具体的产品
 * @author 王喜 
 * @date 2018年3月3日 下午9:22:05
 */
public class ConcreteFactory extends AbstractFactory{

	@Override
	public <T extends Product> T createProduct(Class<T> c) {
		Product product = null;
		try {
			product = (Product) Class.forName(c.getName()).newInstance();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return (T) product;
	}
	
}
