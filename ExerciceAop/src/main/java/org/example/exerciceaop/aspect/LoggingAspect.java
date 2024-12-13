package org.example.exerciceaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("@annotation(org.example.exerciceaop.annotation.Log)")
    public void pointcut() {}

    @Around("pointcut()")
    public void logging(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            Object[] args = proceedingJoinPoint.getArgs();
            System.out.println("Voici les arguments de la méthode :");
            for (Object arg : args) {
                System.out.println(arg.toString());
            }
            Object result = proceedingJoinPoint.proceed();
            System.out.println("Voici les valeurs de retour de la méthode :");
            System.out.println(result);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
