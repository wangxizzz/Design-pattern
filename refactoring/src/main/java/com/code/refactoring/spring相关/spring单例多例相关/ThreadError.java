package com.code.refactoring.spring相关.spring单例多例相关;

/**
 * @Author wangxi
 * @Time 2019/11/10 11:01
 * 多线程并发并发访问有状态的单例Bean
 */
public class ThreadError {
    private UserModel user;
    public void test1(UserModel u) throws Exception {
        this.user = u;                          //1
        test2();
    }

    public void test2() throws Exception {
        System.out.println(user.getId());       //2
    }


    /**
     * 问题分析：
     * 如果该Bean配置为singleton,在并发访问下会出现问题（原子性访问问题）
     * 假设有2个用户user1,user2访问，都调用到了该Bean。
     * 1.当user1 调用到程序中的1步骤的时候，该Bean的私有变量user被付值为user1；
     * 2.理想的状况，当user1走到2步骤的时候，私有变量user应该为user1;
     * 3.但如果在user1调用到2步骤之前，user2开始运行到了1步骤了，由于单态的资源共享，则私有变量user被修改为user2；
     * 4.这种情况下，user1的步骤2用到的user.getId()实际用到是user2的对象。
     * 实际应该是这个例子不应该用实例变量，这样就使得这个Bean由无状态变成了有状态Bean。
     */
}
