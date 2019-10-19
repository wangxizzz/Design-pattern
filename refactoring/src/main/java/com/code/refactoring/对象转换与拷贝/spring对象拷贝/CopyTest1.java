package com.code.refactoring.对象转换与拷贝.spring对象拷贝;

import com.code.refactoring.对象转换与拷贝.User;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Author wangxi
 * @Time 2019/10/16 23:29
 * 测试拷贝bean1
 */
@ToString
@Data
public class CopyTest1 {
    public String outerName;
    public CopyTest1.InnerClass innerClass;
    public List<InnerClass> clazz;
    // 测试是否深拷贝
    public User user;

    @ToString
    @Data
    public static class InnerClass {
        public String InnerName;
    }
}
