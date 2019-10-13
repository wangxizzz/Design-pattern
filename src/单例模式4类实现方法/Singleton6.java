package 单例模式4类实现方法;

/**  
 * @ClassName: Singleton6  
 * @Description: Holder模式
 * @author 王喜 
 * @date 2018年3月12日 下午8:37:53  
*/
//实现懒加载
public class Singleton6 {
	/**
	 * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
	 * 没有绑定关系，而且只有被调用到才会装载，从而实现了延迟加载
	 */

    // 增加字段，测试延迟加载
    public static String s = "aaa";

	private static class SingletonHolder {
	    // 本质是JVM保证了单例的创建
		private static final Singleton6 SINGLETON6 = new Singleton6();
		private SingletonHolder(){	}

	}
	
	private Singleton6(){}
	
	public static synchronized Singleton6 getInstance() {
		return Singleton6.SingletonHolder.SINGLETON6;
	}

	public static String initS() {
	    s = "bbbbb";
	    return s;
    }

    public static void main(String[] args) {
        System.out.println(s);  // 测试延迟加载
        System.out.println(initS());
    }
}
