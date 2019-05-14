package com.code.refactoring.effectivejava3.chapter2.item3.staticfactory;

// Singleton with static factory (Page 17)
public class Elvis {
    private static final Elvis INSTANCE = new Elvis();
    // 会有反射的攻击
    private Elvis() {
        // 防止反射攻击
        if (INSTANCE != null) {
            throw new RuntimeException("不能重复构建对象！");
        }
    }
    public static Elvis getInstance() { return INSTANCE; }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    // This code would normally appear outside the class!
    public static void main(String[] args) {
        Elvis elvis = Elvis.getInstance();
        elvis.leaveTheBuilding();
    }
}
