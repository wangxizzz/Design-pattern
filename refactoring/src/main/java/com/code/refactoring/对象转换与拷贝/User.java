package com.code.refactoring.对象转换与拷贝;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wangxi
 * @Time 2019/10/14 23:04
 * 测试对象转化与拷贝的例子
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private Long age;
}
