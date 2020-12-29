package com.code.refactoring.redis相关.redisson操作;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangxi03 created on 2020/12/28 2:17 下午
 * @version v1.0
 */
@Data
public class TaskBodyDTO implements Serializable {
    private String body;

    private String name;
}
