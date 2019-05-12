package com.code.refactoring.demo02;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * <Description>
 *
 * @author wangxi
 */
public class DemoService {
    public void function() {
        // 判断两个时间的大小
        DateTimeFormatter mySelfFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time1 = LocalTime.parse("22:00", mySelfFormatter);
        LocalTime time2 = LocalTime.now();
        System.out.println(time1.compareTo(time2));
        LocalDate localDate = LocalDate.now().plusDays(1L);
        System.out.println(localDate.plusDays(1));
        // 判断星期几
        DateTimeFormatter mySelfFormatter1 = DateTimeFormatter.ofPattern("EEEE");
        System.out.println(LocalDate.now().format(mySelfFormatter1));
    }
}

