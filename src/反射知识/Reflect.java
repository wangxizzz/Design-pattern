package 反射知识;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class Reflect {
	//得到字节码文件Class对象
	@Test
	public void f1() {
		System.out.println(Person.class);
	}
	
	//得到构造函数,并创建对象
	@Test
	public void f2() throws Exception {
		Class<Person> personClass = Person.class;
//		Class<?> personClass = Class.forName("反射知识.Person");
		//注意：后面的参数和定义的类型一致，不需要变为包装类
		Constructor<Person> constructor = personClass.getConstructor(int.class,String.class);
		Person person = (Person) constructor.newInstance(1,"ss");
		System.out.println(person.getId());
	}
	//得到公有函数
	@Test
	public void f3() throws Exception, Exception {
		Class<Person> personClass = Person.class;
//		Constructor<Person> constructor = personClass.getConstructor();
		Person person = personClass.newInstance();
		Method f1Method = personClass.getMethod("f1");
		//通过Person对象执行方法
		Object invoke = f1Method.invoke(person);
	}
	
	//得到私有函数
	@Test
	public void f4() throws Exception, Exception {
		Class<Person> personClass = Person.class;
		Person person = personClass.newInstance();
		Method f2Method = personClass.getDeclaredMethod("f2");
		f2Method.setAccessible(true);
		Object invoke = f2Method.invoke(person);
	}
	//获得私有字段信息
	@Test
	public void f5() throws Exception, Exception {
		Class<Person> personClass = Person.class;
		//要对字段进行赋值
		Constructor<Person> constructor = personClass.getConstructor(int.class,String.class);
		Person person = constructor.newInstance(2,"wangxi");
		Field field = personClass.getDeclaredField("name");
		field.setAccessible(true);
		field.set(person, "xxx");
		System.out.println(field.get(person));
	}
}
