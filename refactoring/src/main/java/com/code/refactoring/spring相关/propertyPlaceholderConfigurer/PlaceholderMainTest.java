package com.code.refactoring.spring相关.propertyPlaceholderConfigurer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author wangxi
 * @Time 2020/3/7 20:23
 *
 * 测试自定义环境加载与占位符替换
 */
public class PlaceholderMainTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/spring.xml");

        StudentService studentService = (StudentService) context.getBean("studentService");
        System.out.println("student name:" + studentService.getName());
    }
}
