package com.code.refactoring.redis相关.redisson操作;

import com.code.refactoring.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wangxi03 created on 2020/12/28 2:15 下午
 * @version v1.0
 */
@Slf4j
public class RedisDelayedQueueTest extends BaseTest {

    @Resource
    private RedisDelayedQueue redisDelayedQueue;

    @Test
    public void test01() {
        //添加需要延迟的DTO

        TaskBodyDTO taskBody = new TaskBodyDTO();
        taskBody.setBody("测试DTO实体类的BODY,3秒之后执行");
        taskBody.setName("测试DTO实体类的姓名,3秒之后执行");
        //添加队列3秒之后执行
        redisDelayedQueue.addQueue(taskBody, 3, TimeUnit.SECONDS);
        taskBody.setBody("测试DTO实体类的BODY,10秒之后执行");
        taskBody.setName("测试DTO实体类的姓名,10秒之后执行");
        //添加队列10秒之后执行
        redisDelayedQueue.addQueue(taskBody, 10, TimeUnit.SECONDS);
        taskBody.setBody("测试DTO实体类的BODY,20秒之后执行");
        taskBody.setName("测试DTO实体类的姓名,20秒之后执行");
        //添加队列20秒之后执行
        redisDelayedQueue.addQueue(taskBody, 20, TimeUnit.SECONDS);


        //监听延迟队列
        RedisDelayedQueue.TaskEventListener<TaskBodyDTO> taskEventListener = new RedisDelayedQueue.TaskEventListener<TaskBodyDTO>() {
            @Override
            public void invoke(TaskBodyDTO taskBodyDTO) {
                //这里调用你延迟之后的代码
                log.info("执行...." + taskBodyDTO.getBody() + "===" + taskBodyDTO.getName());
            }
        };
        redisDelayedQueue.getQueue(TaskBodyDTO.class, taskEventListener);
    }
}