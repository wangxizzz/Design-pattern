package 代理模式;

/**  
 * @ClassName: SimpleProxyDemo  
 * @Description: 
 * @author 王喜 
 * @date 2018年3月25日 下午3:22:13  
*/
public class SimpleProxyDemo {
	//客户端调用代理的方法
	
	public static void f1(Interface obj) {
		obj.doSomething();
		obj.doSomethingElse("ssss");
	}
	
	public static void main(String[] args) {
//		f1(new RealObject());
		f1(new SimpleProxy(new RealObject()));
	}
}
