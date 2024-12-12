package org.example.demoaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectAround {
    @Pointcut("@annotation(org.example.demoaop.annotation.AroundAnnotation)")
    public void aroundPointcut() {
    }

//    @Before("aroundPointcut()")

    @Around("aroundPointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            System.out.println("around cut");

            Object[] args = proceedingJoinPoint.getArgs();
            System.out.println(args);
            Object result = proceedingJoinPoint.proceed();
            return result;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            return null;
        }
    }
}
