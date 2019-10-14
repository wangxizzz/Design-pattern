package com.code.refactoring.demo.demo02;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

import java.util.Date;

/**
 * <Description>
 *
 * @author wangxi
 */
public class RefactorDemoService {
    // 很好的joda time的操作实例
    // 更多参照：
    // https://blog.csdn.net/qq_36838191/article/details/81296987 介绍了DateTime(相当于Calendar)的操作
    // joda time 对日期的格式化    https://www.jianshu.com/p/cb4521194707

    final DateTime DISTRIBUTION_TIME_SPLIT_TIME = new DateTime().withTime(15,0,0,0);
    // 返回值为Date,更具有通用性
    private Date calculateDistributionTimeByOrderCreateTime(Date orderCreateTime){
        DateTime orderCreateDateTime = new DateTime(orderCreateTime);
        Date tomorrow = orderCreateDateTime.plusDays(1).toDate();
        Date theDayAfterTomorrow = orderCreateDateTime.plusDays(2).toDate();
        return orderCreateDateTime.isAfter(DISTRIBUTION_TIME_SPLIT_TIME) ? wrapDistributionTime(theDayAfterTomorrow) : wrapDistributionTime(tomorrow);
    }
    // 对上面的结果进行包装
    private Date wrapDistributionTime(Date distributionTime){
        DateTime currentDistributionDateTime = new DateTime(distributionTime);
        DateTime plusOneDay = currentDistributionDateTime.plusDays(1);
        boolean isSunday = (DateTimeConstants.SUNDAY == currentDistributionDateTime.getDayOfWeek());
        return isSunday ? plusOneDay.toDate() : currentDistributionDateTime.toDate() ;
    }
}

