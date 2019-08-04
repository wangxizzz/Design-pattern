package com.code.refactoring.controller;

import com.code.refactoring.aop.MethodMonitor;
import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wxi.wang
 * <p>
 * 2019/8/4 19:31
 * Decription:
 */
@RestController
public class TestController {

    @RequestMapping("test01")
    @MethodMonitor("time01")
    public String test01(HttpServletRequest request, @RequestParam("id") Long id) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 测试抛异常的处理
//        int a = 1/0;
        return "dsadas";
    }
}
