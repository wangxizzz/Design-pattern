package com.code.refactoring.对象转换与拷贝.对象转换;

import com.code.refactoring.对象转换与拷贝.User;
import org.apache.commons.collections.MapUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author wangxi
 * @Time 2019/10/14 23:17
 * 应用反射(其实工具类底层一样用的反射技术)
 * 手动写一个 Bean covert to Map
 */
public class MyBeanMapUtil {

    /**
     * Bean to map
     * @param obj
     */
    public static Map<String, String> beanToMap(Object obj) throws IllegalAccessException {
        Map<String, String> result = new HashMap<>();
        if (obj == null) {
            return result;
        }
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            result.put(field.getName(), valueOf(field.get(obj)));
        }
        return result;
    }

    /**
     * Map To Bean.开发中禁止方法返回Map
     * @param beanClass
     * @param paramMap map的value必须是Object，否则给Bean赋值时，会报错
     * @param <T>
     * @return
     */
    public static <T> T mapToBean(Class<T> beanClass, Map<String, Object> paramMap) throws IllegalAccessException, InstantiationException {
        if (MapUtils.isEmpty(paramMap)) {
            return null;
        }
        T obj = beanClass.newInstance();
        Field[] fields = beanClass.getDeclaredFields();
        for (Field field : fields) {
            int mod = field.getModifiers();
            if (Modifier.isFinal(mod) || Modifier.isStatic(mod)) {
                continue;
            }
            // 设置可以访问私有字段,需要获取字段的名称
            field.setAccessible(true);
            field.set(obj, paramMap.get(field.getName()));
        }
        return obj;
    }

    public static String valueOf(Object obj) {
        if (obj == null) {
            return "";
        }
        return obj.toString();
    }

    public static void main(String[] args) throws Exception{
        User user = new User();
        user.setId(1);
        user.setUsername("aa");
        user.setAge(100L);
        Map<String, String> map = beanToMap(user);
        System.out.println(map);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", 1);
        map2.put("username", "aaa");
        map2.put("age", 100L);
        User user2 = mapToBean(User.class, map2);
        System.out.println(user2);
    }
}
