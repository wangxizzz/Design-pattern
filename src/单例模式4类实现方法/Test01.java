package 单例模式4类实现方法;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author wangxi
 * @Time 2019/10/13 21:08
 */
public class Test01 {
    @Test
    public void test01() {
        Map<Integer, Boolean> map = new ConcurrentHashMap<>();
        // 第一次不存在会返回null
        System.out.println(map.put(1, Boolean.FALSE));
        // 会返回原有值
        System.out.println(map.put(1, Boolean.TRUE));
    }
}
