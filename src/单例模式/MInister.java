package 单例模式;
/**
 * 臣子类
 * @ClassName: MInister  
 * @Description: 得到单例对象
 * @author 王喜 
 * @date 2018年3月3日 下午3:53:46
 */
public class MInister {
	public static void main(String[] args) {
		Emperor emperor1 = Emperor.getInstance();
		System.out.println(emperor1);
		Emperor emperor2 = Emperor.getInstance();
		System.out.println(emperor2);
	}
}
