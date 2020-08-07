package com.code.refactoring.controller.controller线程安全;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller默认是单例
 *
 * @author wangxi created on 2020/8/7 2:18 PM
 * @version v1.0
 */
@RestController
public class UnsafeController {
    // 线程不安全，多个线程共享一个对象里的属性，并发操作就有问题
    int i = 0;

    @RequestMapping("unsafe/a")
    public String a() {
        i++;
        return String.valueOf(i);
    }
}
