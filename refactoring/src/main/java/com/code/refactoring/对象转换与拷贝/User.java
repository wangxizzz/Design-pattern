package com.code.refactoring.对象转换与拷贝;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author wangxi
 * @Time 2019/10/14 23:04
 * 测试对象转化与拷贝的例子
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private Long age;
}
