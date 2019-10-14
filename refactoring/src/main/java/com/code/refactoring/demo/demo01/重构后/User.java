package com.code.refactoring.demo.demo01.重构后;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <Description>
 *
 * @author wangxi
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)   // 可以开启链式调用
@Builder   // 开启build方式
public class User {

    private String username;
    private int age;

    // 如果两个类的属性不一样(属性个数，属性类型)，那么copy后的结果就是属性值为null
    private String testBeanUtil;

    public static void main(String[] args) {
        new User().setAge(1).setUsername("s");
        User.builder().age(2).username("ss").build();
    }
}

