package com.code.refactoring.spring相关.事件驱动相关.jdk事件驱动;

/**
 * @author wangxi created on 2020/11/1 17:54
 * @version v1.0
 */
public class MainClient {
    // 测试方法如下：
    public static void main(String[] args) {
        Person person = new Person("fsx");

        // 来10只猫 观察这个人
        for (int i = 0; i < 10; i++) {
            person.addObserver(new Cat("cat" + i));
        }

        //开始放fish，这时候观察的猫就应该都过来了
        person.giveFish("草鱼");
    }
}
