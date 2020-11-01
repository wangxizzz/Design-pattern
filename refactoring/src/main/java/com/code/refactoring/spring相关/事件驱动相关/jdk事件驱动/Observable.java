package com.code.refactoring.spring相关.事件驱动相关.jdk事件驱动;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author wangxi created on 2020/11/1 17:46
 * @version v1.0
 */
public class Observable {
    // 是否变化，决定了后面是否调用update方法
    private boolean changed = false;
    // 用来存放所有`观察自己的对象`的引用，以便逐个调用update方法
    // 需要注意的是：1.8的jdk源码为Vector(线程安全的)，有版本的源码是ArrayList的集合实现；
    private List<Observer> obs;

    public Observable() {
        obs = new CopyOnWriteArrayList<>();
    }

    //添加一个观察者 注意调用的是addElement方法，添加到末尾   所以执行时是倒序执行的
    public void addObserver(Observer o) {
        obs.add(o);
    }

    public void deleteObserver(Observer o) {
        obs.remove(o);
    }

    //删除所有的观察者
    public void deleteObservers() {
        obs.clear();
    }

    // 循环调用所有的观察者的update方法
    public void notifyObservers() {
        obs.forEach(observer -> observer.update(this, null));
    }

    public void notifyObservers(Object arg) {
        obs.forEach(observer -> observer.update(this, arg));
    }

    public int countObservers() {
        return obs.size();
    }

    // 修改changed的值
    protected synchronized void setChanged() {
        changed = true;
    }

    protected synchronized void clearChanged() {
        changed = false;
    }

    public synchronized boolean hasChanged() {
        return changed;
    }
}
