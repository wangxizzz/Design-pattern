package com.code.refactoring.spring相关.spring多态相关;

import org.springframework.stereotype.Component;

/**
 * @Author wangxi
 * @Time 2019/10/25 23:23
 */
@Component
public class BlackPerson implements Person{
    @Override
    public void say() {
        System.out.println("I am a black man!");
    }
}
