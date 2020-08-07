package com.code.refactoring.controller.controller线程安全;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wangxi created on 2020/8/7 2:33 PM
 * @version v1.0
 */
@RestController
public class ThreadLocalController {

    // 可以保证每个线程独享count值，但是tomcat无法保证每次请求都起不同的线程，tomcat里面线程池机制
    // 因此用threadLocal解决有状态的bean多线程安全性存在问题。todo 需要了解下spring是如果解决这个问题
    public ThreadLocal<Integer> count = new ThreadLocal<>();

    @RequestMapping("threadLocal/a")
    public String a() {
        if (count.get() == null) {
            count.set(1);
        } else {
            count.set(count.get() + 100);
        }
        return String.valueOf(count.get());
    }
}
