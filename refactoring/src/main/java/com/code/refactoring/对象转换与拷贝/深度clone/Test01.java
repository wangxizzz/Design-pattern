package com.code.refactoring.对象转换与拷贝.深度clone;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.SerializationUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author wangxi
 * @Time 2019/10/19 19:41
 * 利用 SerializationUtils 进行深拷贝
 * 利用序列化与反序列化进行深拷贝
 */
public class Test01 {
    /** Apache的SerializationUtil深度clone*/
    public static void fun01() {
        ChildClass childClass = new ChildClass("1", 2);
        FatherClass fatherClass = new FatherClass("aa", 324, childClass);

        FatherClass clone = SerializationUtils.clone(fatherClass);
        System.out.println(fatherClass);
        System.out.println(clone);
        System.out.println(fatherClass.hashCode());
        System.out.println(clone.hashCode());
        System.out.println("==========");
        System.out.println(fatherClass.childClass == clone.childClass);
        System.out.println(fatherClass.childClass);
        System.out.println(clone.childClass);
    }
    // 浅拷贝
    public static void fun02() throws InvocationTargetException, IllegalAccessException {
        ChildClass childClass = new ChildClass("1", 2);
        FatherClass fatherClass = new FatherClass("aa", 324, childClass);
        FatherClass clone = new FatherClass();
        BeanUtils.copyProperties(clone, fatherClass);
        System.out.println(fatherClass);
        System.out.println(clone);
        System.out.println(fatherClass.hashCode());
        System.out.println(clone.hashCode());
        System.out.println("==========");
        System.out.println(fatherClass.childClass == clone.childClass);
        System.out.println(fatherClass.childClass);
        System.out.println(clone.childClass);
    }

    public static void main(String[] args) throws Exception{
        fun01();
        System.out.println("-------------------");
        fun02();
    }
}
