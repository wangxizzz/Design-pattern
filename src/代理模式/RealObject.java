package 代理模式;

/**  
 * @ClassName: RealObject  
 * @Description: 
 * @author 王喜 
 * @date 2018年3月25日 下午3:21:33  
*/
public class RealObject implements Interface{

	@Override
	public void doSomething() {
		System.out.println("doSomething");
	}

	@Override
	public void doSomethingElse(String args) {
		System.out.println("doSomethingElse");
	}
	
}
