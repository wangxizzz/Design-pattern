package com.code.refactoring.redis相关.redisson操作;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wangxi
 * @Time 2019/11/16 21:38
 * redisson的配置
 */

@Configuration
public class RedissonConfig {
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

    @Value("${spring.redis.password}")
    private String password;

    //@Bean
    // 为了保证系统启动不报错，因为redis不会每次单测都会启动。所以先注释掉
    public RedissonClient redissonClient(){
        Config config = new Config();
        // 如果没密码的话，就不要带上设置密码的方法了。
        config.useSingleServer().setAddress("redis://" + host + ":" + port);
        return Redisson.create(config);
    }

}
