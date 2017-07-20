package com.mt.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * created by anyanwen on 2017/7/17.
 */
@Aspect
@Component
public class MonitorAspect {
    @Autowired
    private MonitorModel monitorModel;

    @Pointcut("execution(* com.mt.aop.*.foo(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object caculate(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        Object result = null;
        System.out.println("111");
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long end = System.currentTimeMillis();
        monitorModel.add(joinPoint.getSignature().getName(), (int) (end - start));
        return result;
    }
}
