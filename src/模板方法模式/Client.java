package 模板方法模式;
/**
 * 
 * @ClassName: Client  
 * @Description: 来一个用户启动一辆车
 * @author 王喜 
 * @date 2018年3月4日 下午8:07:19
 */
public class Client {
	public static void main(String[] args) {
		//启动宝马
		//注意一个对象的表面类型最好是抽象类或者是接口
		CarModel baoma = new Baoma();
		baoma.run();    // 可以调用子类重写的方法，多态的体现。
	}
}
