package com.code.refactoring.spring相关.事务相关.事务service;

import com.code.refactoring.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 *
 * @author wangxi created on 2020/8/2 11:09 AM
 * @version v1.0
 */
public class AnnotationTransactionServiceTest extends BaseTest {

    @Resource
    private AnnotationTransactionService annotationTransactionService;

    @Test
    public void fun01Test() {
        annotationTransactionService.fun01();
    }

    @Test
    public void fun02Test() {
        annotationTransactionService.fun02();
    }

    @Test
    public void fun02Correct01Test() {
        annotationTransactionService.fun02Correct01();
    }

    @Test
    public void fun02Correct02Test() {
        annotationTransactionService.fun02Correct02();
    }
}