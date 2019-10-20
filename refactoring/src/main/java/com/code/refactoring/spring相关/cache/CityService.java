package com.code.refactoring.spring相关.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author wangxi
 * @Time 2019/10/20 15:40
 * 参考网址：https://www.jianshu.com/p/49fc4065201a
 * 测试方法见测试类，在源码看过之后，有待验证
 */
@Service
public class CityService {

    public static Map<String, String> map = new ConcurrentHashMap<>();

    static {
        map.put("北京","中国");
        map.put("武汉", "湖北");
        map.put("厦门", "中国");
        map.put("杭州", "江苏");
        map.put("纽约","美国");
    }

    @Cacheable("getCountry")
    public String getCountry(String cityName) {
        System.out.println("=====getCountry");
        return map.get(cityName);
    }

    @Cacheable("getProvince")
    public String getProvince(String cityName) {
        System.out.println("====getProvince");
        return map.get(cityName);
    }

    // 更新数据
    public void updateProvince(String cityName) {

    }
}
