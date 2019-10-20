package com.code.refactoring.redis相关;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wangxi
 * @Time 2019/10/20 13:33
 * 测试redis的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisBean {
    private String username;
    private Integer age;
}
