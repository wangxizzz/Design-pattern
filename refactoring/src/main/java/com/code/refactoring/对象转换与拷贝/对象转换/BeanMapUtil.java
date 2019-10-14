package com.code.refactoring.对象转换与拷贝.对象转换;

import com.code.refactoring.对象转换与拷贝.User;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author wangxi
 * @Time 2019/10/14 23:04
 */
public class BeanMapUtil {
    // bean to Map
    public static Map<String, String> userToMap() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        User user = new User();
        user.setId(1);
        user.setUsername("aa");
        user.setAge(100L);
        // 注意，只能使用String,String的 Map接收返回值
        Map<String, String> map = BeanUtils.describe(user);
        System.out.println(map);
        return map;
    }

    public static User mapToUser() throws InvocationTargetException, IllegalAccessException {
        Map<String, String> map = new HashMap<>();
        map.put("id", "1");
        map.put("username", "aaa");
        map.put("age", "100");
        User user = new User();
        BeanUtils.populate(user, map);
        System.out.println(user);
        return user;
    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        userToMap();
        mapToUser();
    }
}
