package com.code.refactoring.spring相关.事务相关.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DemoBookDO
 * @author: wangxi03
 * @date: 2020/08/02 10:44:23 
 */
@Getter
@Setter
@ToString
@Builder
public class DemoBookDO implements Serializable {
    /**
     * 自增id
     */
    private Long id;

    private String bookName;

    private String bookDesc;

    private Date publishTime;

    private Integer sellCount;

    private Date createTime;

    private Date updateTime;
}
