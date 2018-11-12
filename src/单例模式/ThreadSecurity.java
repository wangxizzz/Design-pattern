package 单例模式;
/**
 * 
 * @ClassName: ThreadSecurity  
 * @Description: 线程不安全的单例
 * @author 王喜 
 * @date 2018年3月3日 下午3:56:37
 */
public class ThreadSecurity {
	
	private static ThreadSecurity THREAD_SECURITY = null;
	
	private ThreadSecurity() {
		
	}
	
	//通过该方法获得实例对象
	/**
	 * 线程不安全：当系统的并发量变高时，new一个对象需要一定的时间，但是此时又有一个线程执行到
	 * 	if (THREAD_SECURITY == null)语句时，判断为true，这样内存中就会产生两个对象实例！
	 * @return
	 */
	private static ThreadSecurity getInstance() {
		if (THREAD_SECURITY == null) {
			THREAD_SECURITY = new ThreadSecurity();
		}
		return THREAD_SECURITY;
	}
}
