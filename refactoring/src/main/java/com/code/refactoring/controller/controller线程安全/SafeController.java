package com.code.refactoring.controller.controller线程安全;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wangxi created on 2020/8/7 2:23 PM
 * @version v1.0
 */
@RestController
@Scope("prototype")   // 每调用一次controller方法，都会创建一个对象,线程安全
public class SafeController {
    int i = 0;

    @RequestMapping("safe/a")
    public String a() {
        i++;
        System.out.println(Thread.currentThread().getName());
        // 每次调用打印的地址不相同
        System.out.println(this);
        return String.valueOf(i);
    }
}
