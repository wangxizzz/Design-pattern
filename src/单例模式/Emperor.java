package 单例模式;
/**
 * 
 * @ClassName: Emperor  
 * @Description:测试单例模式   提供单例对象 皇帝
 * @author 王喜 
 * @date 2018年3月3日 下午3:48:37
 */
public class Emperor {
	
	private static final Emperor EMPEROR = new Emperor();
	
	private Emperor() {
		
	}
	
	public static Emperor getInstance() {
		return EMPEROR;
	}
}
