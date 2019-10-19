package com.code.refactoring.对象转换与拷贝.深度clone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * <Description>
 *
 * @author wangxi
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChildClass implements Serializable {
    public String name;
    public int age;
}

