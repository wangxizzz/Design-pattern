package com.code.refactoring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync  // 开启方法@Async异步扫描
@EnableCaching   //开启Cacheable的扫描
@ServletComponentScan   // 开启WebServlet扫描
@MapperScan("com.code.refactoring.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class RefactoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(RefactoringApplication.class, args);
    }

}
