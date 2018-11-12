package 反射知识;

public class Person {
	private int id;
	private String name;
	
	static{
		System.out.println("Person初始化。。。");
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void f1(){
		System.out.println("公有方法f1()");
	}
	
	private void f2() {
		System.out.println("私有方法f2()");
	}
	
	public Person() {

	}

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
}
