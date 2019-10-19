package com.code.refactoring.对象转换与拷贝.深度clone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <Description>
 *
 * @author wangxi
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FatherClass implements Serializable {
    public String name;
    public int age;
    public ChildClass childClass;
}

