package 模板方法模式;
/**
 * 
 * @ClassName: CarModel  
 * @Description: 建立一个抽象的车模型   SpringMVC采用了模板方法模式
 * @author 王喜
 * @date 2018年3月4日 下午7:57:26
 */
public abstract class CarModel {
	//首先要能启动
	public abstract void start();
	//再者就是能鸣笛
	public abstract void alarm();
	//到达目的地停止
	public abstract void stop();
	//最后跑(跑需要的条件是执行上面的三个方法)  在父类中代码抽取出来为模板方法,子类只需要实现上面三个方法，不需要实现run()
	public final void run() {   //模板方法一般用final修饰
 		start();
		alarm();
		//到达目的地停车
		stop();
	}
}
