package org.example.demoaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAspectAdvice {
   /* @Before("execution(* org.example.demoaop.service.*.*(..))")
    public void before() {
        System.out.println("Run before each method");
    }

    @After("execution(* org.example.demoaop.service.*.*(..))")
    public void after() {
        System.out.println("Run after each method");
    }

    @AfterReturning(value = "execution(* org.example.demoaop.service.DemoService.methodWithResult())", returning = "result")
    public void afterReturning(String result) {
        System.out.println("Run after methodWithResult and result is : " + result);
    }*/

    @Pointcut("@annotation(org.example.demoaop.annotation.ExceptionAnnotation)")
    public void exceptionPointcut() {
    }

    @AfterThrowing(value = "exceptionPointcut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        System.out.println("Exception message in Advice " + e.getMessage() + " " + joinPoint.getSignature().getName());
    }

}
