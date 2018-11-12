package 装饰模式;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:王喜
 * @Description :  准备一些测试的数据
 * @Date: 2018/4/28 0028 15:50
 */
public class TempDB {

    private TempDB(){}

    public static Map<String,Double> map = new HashMap<>();

    /**
     * 姓名，销售额
     */
    static {
        //填充测试数据
        map.put("张三",10000.0);
        map.put("李四",20000.0);
        map.put("王五",30000.0);
    }
}
