package com.code.refactoring.spring相关.事件驱动相关.jdk事件驱动;

/**
 * @author wangxi created on 2020/11/1 17:53
 * @version v1.0
 */
public class Cat implements Observer{
    public String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        String preffix = o.toString();
        if (o instanceof Person) {
            preffix = ((Person) o).name;
        }
        System.out.println(preffix + "主人放 " + arg + "~了," + name + "去吃鱼吧");
    }
}
