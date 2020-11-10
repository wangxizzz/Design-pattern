package com.code.refactoring.spring相关.事件驱动相关.jdk事件驱动;

/**
 * @author wangxi created on 2020/11/1 17:52
 * @version v1.0
 */
public class Person extends Observable {
    public String name;

    public Person(String name) {
        this.name = name;
    }

    // 给鱼：这样所有观察的猫都会过来了
    // fishType: 鱼的名字
    public void giveFish(String fishName) {
        setChanged(); // 这个一定不能忘
        notifyObservers(fishName);
    }
}
