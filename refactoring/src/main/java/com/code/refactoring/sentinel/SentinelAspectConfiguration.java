package com.code.refactoring.sentinel;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangxi created on 2021/3/17 23:24
 * @version v1.0
 */
@Configuration
public class SentinelAspectConfiguration {
    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }


    // 接入控制台后，可在控制台配置流控
//    @PostConstruct
//    public void initDegradeRule() {
//        List<FlowRule> rules = new ArrayList<FlowRule>();
//        FlowRule rule1 = new FlowRule();
//        rule1.setResource("getOrderInfo");
//        // QPS控制在2以内
//        rule1.setCount(1);
//        // QPS限流
//        rule1.setGrade(RuleConstant.FLOW_GRADE_QPS);
//        rule1.setLimitApp("default");
//        rules.add(rule1);
//        FlowRuleManager.loadRules(rules);
//    }
}
