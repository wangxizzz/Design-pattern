package com.code.refactoring.对象转换与拷贝.深度clone;

import net.sf.cglib.beans.BeanCopier;

/**
 * @Author wangxi
 * @Time 2019/10/19 20:23
 * 测试BeanCopier 仍然是浅拷贝
 *
 */
public class BeanCopierTest {
    public static void main(String[] args) {
        ChildClass childClass = new ChildClass("1", 2);
        FatherClass fatherClass = new FatherClass("aa", 324, childClass);
        FatherClass clone = new FatherClass();

        BeanCopier copier = BeanCopier.create(fatherClass.getClass(), clone.getClass(), false);

        copier.copy(fatherClass, clone, null);

        System.out.println(fatherClass.getChildClass());
        System.out.println(clone.getChildClass());
    }
}
