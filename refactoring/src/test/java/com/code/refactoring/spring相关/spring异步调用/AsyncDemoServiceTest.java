package com.code.refactoring.spring相关.spring异步调用;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncDemoServiceTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private AsyncDemoService demoService;

    @Test
    public void task02() {
        long now = System.currentTimeMillis();
        logger.info("[task02][开始执行]");
        /**
         * 本质这两个异步方法并没有完成。随着main thread的结束而结束
         */
        demoService.execute01Async();
        demoService.execute02Async();

        logger.info("[task02][结束执行，消耗时长 {} 毫秒]", System.currentTimeMillis() - now);
    }

    @Test
    public void task04() throws ExecutionException, InterruptedException {
        long now = System.currentTimeMillis();
        logger.info("[task04][开始执行]");

        // <1> 执行任务
        ListenableFuture<Integer> execute01Result = demoService.execute01AsyncWithListenableFuture();
        logger.info("[task04][execute01Result 的类型是：({})]", execute01Result.getClass().getSimpleName());

        execute01Result.addCallback(new ListenableFutureCallback<Integer>() { // <2.2> 增加成功和失败的统一回调

            @Override
            public void onSuccess(Integer result) {
                logger.info("[onSuccess][result: {}]", result);
            }

            @Override
            public void onFailure(Throwable ex) {
                logger.info("[onFailure][发生异常]", ex);
            }

        });
        // <3> 阻塞等待结果
        execute01Result.get();

        logger.info("[task04][结束执行，消耗时长 {} 毫秒]", System.currentTimeMillis() - now);
    }
}