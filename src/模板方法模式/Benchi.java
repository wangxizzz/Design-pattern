package 模板方法模式;

public class Benchi extends CarModel{

	@Override
	public void start() {
		System.out.println("奔驰启动了。。。");
	}

	@Override
	public void alarm() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	//这段代码抽取出来，在父类封装为模板方法
//	@Override
//	public void run() {
//		start();
//		alarm();
//		//到达目的地停车
//		stop();
//	}
	
}
