package org.example.exerciceaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionAspect {

    @Pointcut("@annotation(org.example.exerciceaop.annotation.Exception))")
    public void pointCut() {}

    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        System.out.println("Exception: " + e.getMessage() + "\n" + joinPoint.getSignature().getName());
    }
}
