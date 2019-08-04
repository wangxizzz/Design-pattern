package com.code.refactoring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

/**
 * Created by wxi.wang
 * <p>
 * 2019/8/4 17:10
 * Decription:
 */
@Aspect
@Component  // 告诉spring需要加到IOC容器中去
@Slf4j
public class MethodMonitorAspect {

    // 定义一个切入点,方便后面用的时候引用，而不用写一串表达式
    @Pointcut("@annotation(com.code.refactoring.aop.MethodMonitor)")
    public void time() {  // time()就表示这个切入点的引用，可以去任何名字
        // 这里面可以是任意代码。不会执行
    }

    // 把切入点定义好之后，然后开始定义通知.

    /**
     * 环绕通知：
     *   环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，
     *   执行完毕是否需要替换返回值。
     *   环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     */
    @Around("time()&&@annotation(methodMonitor)")
    public Object aroundMethodTime(ProceedingJoinPoint joinPoint, MethodMonitor methodMonitor) {
        System.out.println("================================");
        // 获取目标方法的执行参数
        Object[] args = joinPoint.getArgs();
        System.out.println(args[1]);
        long start = System.currentTimeMillis();
        try {
            String result = (String)joinPoint.proceed(args); // 方法执行完毕后又跳到这里执行
            // 对方法的返回值处理，但是最终的返回类型不能改变.
            // 如果没发生异常，执行到return，就会返回
            result = "4324324234sda";
            return result;
        }catch (Throwable e) {
            log.error("统计方法时间失败 ", e);   // 此时只是把异常栈打出来，程序并没有挂，会继续往下走
            //throw new RuntimeException(e);  // 这句话执行时，程序直接挂了，不会往下走了。
                // 如果想抛出RuntimeException，那么只能使用finally代码块了，在里面算出执行时间
        }
//        finally {
//            long costTime = System.currentTimeMillis() - start;
//            String methodName = joinPoint.getSignature().getName();  // 获取方法名称
//            String monitorName = methodMonitor.value();  // 获取注解的value()的值
//            log.info("{}方法的执行时间是: {}", methodName, costTime);
//        }
        long costTime = System.currentTimeMillis() - start;
        String methodName = joinPoint.getSignature().getName();  // 获取方法名称
        String monitorName = methodMonitor.value();  // 获取注解的value()的值
        log.info("{}方法的执行时间是: {}", methodName, costTime);
        return null;
    }

}
