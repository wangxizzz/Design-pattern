package 单例模式4类实现方法;

/**  
 * @ClassName: Singleton6  
 * @Description: Holder模式
 * @author 王喜 
 * @date 2018年3月12日 下午8:37:53  
*/
//实现懒加载
public class Singleton6 {
	private static class SingletonHolder {
		private static final Singleton6 SINGLETON6 = new Singleton6();
		private SingletonHolder(){	}
	}
	
	private Singleton6(){}
	
	public static synchronized Singleton6 getInstance() {
		return SingletonHolder.SINGLETON6;
	}
}
