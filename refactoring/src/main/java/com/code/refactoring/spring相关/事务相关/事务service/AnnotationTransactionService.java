package com.code.refactoring.spring相关.事务相关.事务service;

import com.code.refactoring.mapper.DemoBookMapper;
import com.code.refactoring.mapper.DemoOrderMapper;
import com.code.refactoring.spring相关.事务相关.domain.DemoBookDO;
import com.code.refactoring.spring相关.事务相关.domain.DemoOrderDO;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 *
 * 事务测试
 *
 * @author wangxi created on 2020/8/2 10:49 AM
 * @version v1.0
 */
@Service("annotationTransactionService")
public class AnnotationTransactionService implements ApplicationContextAware {
    @Resource
    private DemoOrderMapper demoOrderMapper;

    @Resource
    private DemoBookMapper demoBookMapper;

    @Resource
    private TransactionTemplate transactionTemplate;

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    public String getOrderNo() {
        return UUID.randomUUID().toString();
    }

    public String getOrderUserName() {
        return "wangxi";
    }

    @Transactional(rollbackFor = Exception.class)   // 事务会生效
    public void fun01() {
        // 先有书，再有订单
        DemoBookDO demoBookDO = toDemoBook();
        demoBookMapper.insert(demoBookDO);

        int i = 1/0;

        DemoOrderDO demoOrderDO = toDemoOrder(demoBookDO);
        demoOrderMapper.insert(demoOrderDO);
    }

    // 嵌套事务的问题
    public void fun02() {
        System.out.println("invoke fun02");
        // 此时事务不会生效
        fun02Transaction();
    }

    // 嵌套事务解决办法
    public void fun02Correct01() {
        // 使用编程式事务，事务模板
        transactionTemplate.execute(status -> {
            // 先有书，再有订单
            DemoBookDO demoBookDO = toDemoBook();
            int booRes = demoBookMapper.insert(demoBookDO);

            int i = 3/0;

            DemoOrderDO demoOrderDO = toDemoOrder(demoBookDO);
            int orderRes = demoOrderMapper.insert(demoOrderDO);

            if (booRes > 0 && orderRes > 0) {
                return true;
            }
            return false;
        });
    }


    /**
     * 如果直接使用fun02Transaction()普通方式调用，
     * 调用并非调用的是代理类中的方法，是不会被切进去的。换言之，必须要调用代理类才会被切进去。
     *
     */
    // 嵌套事务解决办法2
    public void fun02Correct02() {

        System.out.println("fun02Correct02............");
        // 获取当前代理对象
//        AnnotationTransactionService currentProxy = (AnnotationTransactionService) AopContext
//                .currentProxy();
        // 获取当前代理对象方法2
        AnnotationTransactionService currentProxy =
                applicationContext.getBean(AnnotationTransactionService.class);

        currentProxy.fun02Transaction();

    }

    /**
     * 方法如果为private编译会报错，改为public时，事务仍然不会生效(嵌套事务的典型现象)
     *
     * 事务仍然不会生效的概念：
     * book表会插入成功，然后抛出异常，order表插入失败。 代码的异常不会导致book表记录的回滚，会出现数据不一致的情况。
     */
    @Transactional(rollbackFor = Exception.class)
    public void fun02Transaction() {
        // 先有书，再有订单
        DemoBookDO demoBookDO = toDemoBook();
        demoBookMapper.insert(demoBookDO);

        int i = 2/0;

        DemoOrderDO demoOrderDO = toDemoOrder(demoBookDO);
        demoOrderMapper.insert(demoOrderDO);
    }

    private DemoBookDO toDemoBook() {
        return DemoBookDO.builder()
                .bookName("Java编程思想")
                .bookDesc("入门书籍")
                .publishTime(new Date())
                .sellCount(10000)
                .createTime(new Date())
                .updateTime(new Date())
                .build();
    }

    private DemoOrderDO toDemoOrder(DemoBookDO demoBookDO) {
        return DemoOrderDO.builder()
                .orderNo(getOrderNo())
                .orderName("书籍订单")
                .orderUserName(getOrderUserName())
                .price(BigDecimal.valueOf(100))
                .bookId(demoBookDO.getId())
                .createTime(new Date())
                .updateTime(new Date())
                .build();
    }
}
