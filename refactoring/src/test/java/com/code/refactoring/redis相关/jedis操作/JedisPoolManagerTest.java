package com.code.refactoring.redis相关.jedis操作;


import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author wangxi
 * @Time 2019/10/20 16:53
 */
public class JedisPoolManagerTest {

    private Jedis jedis;

    @Before
    public void getConnect() {
        jedis = JedisPoolManager.getMgr().getResource();
    }

    /**
     * 测试 string
     */
    @Test
    public void test01() {
        jedis.set("redis", "myredis");
        System.out.println(jedis.get("a"));
        // 有就追加，没有则创建
        jedis.append("redis", "yourredis");
        jedis.append("mq", "RabbitMQ");
        // 测试增加
        String pv = jedis.set("pv", "0");
        System.out.println("pv:" + pv);
        jedis.incr("pv");
        jedis.incrBy("pv", 10);
        System.out.println("pv:" + pv);
        // 测试批量set与get
        jedis.mset("firstName", "ricky", "lastName", "Fung");
        System.out.println(jedis.mget("firstName", "lastName"));
    }

    /**
     * 测试hash
     */
    @Test
    public void test02() {
        Map<String, String> cityMap = new HashMap<>();
        cityMap.put("beijing", "1");
        cityMap.put("shanghai", "2");
        // 测试hash 的批量设置与批量获取
        jedis.hmset("city", cityMap);
        System.out.println(jedis.hget("city", "beijing"));
        System.out.println(jedis.hlen("city"));
        System.out.println(jedis.hmget("city", "beijing", "shanghai"));
        // 测试其他
        jedis.hset("address", "country", "CN");
        jedis.hset("address", "province", "BJ");
        jedis.hset("address", "city", "Beijing");
        jedis.hset("address", "district", "Chaoyang");

        System.out.println("city:" + jedis.hget("address", "city"));
        System.out.println("keys:" + jedis.hkeys("address"));
        System.out.println("values:" + jedis.hvals("address"));
    }

    /**
     * 测试 list
     */
    @Test
    public void test03() {
        jedis.lpush("hobbies", "reading");
        jedis.lpush("hobbies", "basketball");
        jedis.lpush("hobbies", "shopping");

        List<String> hobbies = jedis.lrange("hobbies", 0, -1);
        System.out.println("hobbies:" + hobbies);

        jedis.del("hobbies");
    }

    /**
     * 测试 set
     */
    @Test
    public void test04() {
        List<String> list = Lists.newArrayList("ricky", "kings", "demonsss");
        jedis.sadd("name", list.toArray(new String[list.size()]));
        System.out.println("size:" + jedis.scard("name"));
        System.out.println("exists:" + jedis.sismember("name", "ricky"));
        System.out.println(String.format("all members: %s", jedis.smembers("name")));
        System.out.println(String.format("rand member: %s", jedis.srandmember("name")));
        //remove
        jedis.srem("name", "demon");
    }

    /**
     * 测试 sorted set   zadd
     */
    @Test
    public void test05() {
        jedis.zadd("gift", 0, "car");
        jedis.zadd("gift", 2, "bike");
        Set<String> gift = jedis.zrange("gift", 0, -1);
        System.out.println("gift:" + gift);
    }

    /**
     * redis的事务
     */
}