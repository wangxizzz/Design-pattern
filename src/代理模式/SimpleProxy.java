package 代理模式;

/**  
 * @ClassName: SimpleProxy  
 * @Description: 
 * @author 王喜 
 * @date 2018年3月25日 下午3:21:54  
*/
public class SimpleProxy implements Interface{

	private Interface obj;
	
	public SimpleProxy(Interface obj) {
		this.obj  = obj;
	}
	@Override
	public void doSomething() {
		System.out.println("代理之前的行为");
		obj.doSomething();
	}

	@Override
	public void doSomethingElse(String args) {
		// TODO Auto-generated method stub
		obj.doSomethingElse(args);
		System.out.println("代理之后的行为");
	}
	
}
