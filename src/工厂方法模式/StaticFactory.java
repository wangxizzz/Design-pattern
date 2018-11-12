package 工厂方法模式;
/**
 * 实现工厂方法模式的第二种：不需要extends工厂，直接创建一个工厂
 * @ClassName: StaticFactory  
 * @Description: 
 * @author 王喜 
 * @date 2018年3月3日 下午9:30:51
 */
public class StaticFactory {
	public static <T extends Product> T createProduct(Class<T> c) {
		Product product = null;
		try {
			//得到具体产品的实例
			product = (Product) Class.forName(c.getName()).newInstance();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return (T) product;
	}
}
