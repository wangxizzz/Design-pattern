package com.code.refactoring.spring相关.conditional相关.Conditional注解;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

/**
 * @author wangxi03 created on 2020/10/27 2:48 PM
 * @version v1.0
 */
@Component
public class MacOSCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        Environment environment = conditionContext.getEnvironment();

        String property = environment.getProperty("os.name");
        if (property.contains("Mac OS X")){
            return true;
        }
        return false;
    }

}
