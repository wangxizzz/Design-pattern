package com.code.refactoring.zookeeper.book.chapter05;

import org.apache.zookeeper.data.Stat;

/**
 *
 * @author wangxi
 * 
 */
public class StatUtils {

    public static String printStat(Stat stat) {
        if (null == stat) {
            return "";
        }
        return "Stat[czxid=" + stat.getCzxid() + ", mzxid=" + stat.getMzxid() + ", version=" + stat.getVersion() + "]";
    }
}
