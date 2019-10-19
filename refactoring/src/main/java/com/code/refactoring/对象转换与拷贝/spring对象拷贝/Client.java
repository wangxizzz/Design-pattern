package com.code.refactoring.对象转换与拷贝.spring对象拷贝;

import com.code.refactoring.对象转换与拷贝.User;
import org.springframework.beans.BeanUtils;

/**
 * @Author wangxi
 * @Time 2019/10/16 23:31
 * 测试spring的拷贝
 *
 * spring的拷贝是浅拷贝,而且底层使用反射，性能低
 * 参考连接：
 * https://www.cnblogs.com/tison/p/7840647.html
 */
public class Client {
    /**
     * 1.Spring的BeanUtils的CopyProperties方法需要对应的属性有getter和setter方法(底层使用反射需要调用这俩方法)；
     * 2.如果存在属性完全相同的内部类，但是不是同一个内部类，即分别属于各自的内部类，则spring会认为属性不同，不会copy；
     * 3.泛型只在编译期起作用，不能依靠泛型来做运行期的限制,
     *      特别注意：在List<InnerClass> InnerClass表示内部类，但是在拷贝的对象和source使用
     * 不是同一个InnerClass，那么仍然属性为null,正确做法是遍历List集合，然后每个对象复制一下；
     * 4.最后，spring和apache的copy属性的方法源和目的参数的位置正好相反，所以导包和调用的时候都要注意一下。
     */
    public static void errorCopy() {
        CopyTest1 test1 = new CopyTest1();
        test1.outerName = "hahaha";
        CopyTest1.InnerClass innerClass = new CopyTest1.InnerClass();
        innerClass.InnerName = "hohoho";
        test1.innerClass = innerClass;
        User user = new User(1, "aa", 100L);
        test1.setUser(user);

        System.out.println(test1.toString());
        CopyTest2 test2 = new CopyTest2();
        BeanUtils.copyProperties(test1, test2);

        System.out.println(test2.toString());
    }

    public static void correctCopy() {
        CopyTest1 test1 = new CopyTest1();
        test1.outerName = "hahaha";
        CopyTest1.InnerClass innerClass = new CopyTest1.InnerClass();
        innerClass.InnerName = "hohoho";
        test1.innerClass = innerClass;
        User user = new User(1, "aa", 100L);
        test1.setUser(user);

        System.out.println(test1.toString());
        CopyTest2 test2 = new CopyTest2();
        test2.innerClass = new CopyTest2.InnerClass();
        BeanUtils.copyProperties(test1, test2);
        BeanUtils.copyProperties(test1.innerClass, test2.innerClass);

        System.out.println(test2.toString());

        System.out.println("======测试是否是深度clone========");
        System.out.println(test1.getUser() == test2.getUser());
        System.out.println(test1.getUser());
        System.out.println(test2.getUser());
        System.out.println(test1.getUser().getUsername().hashCode());
        System.out.println(test2.getUser().getUsername().hashCode());
    }

    public static void main(String[] args) {
        correctCopy();
    }
}
