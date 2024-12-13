package org.example.exerciceaop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {

    private long duration;

    @Pointcut("@annotation(org.example.exerciceaop.annotation.Performance)")
    public void pointCut() {}

    @Before("pointCut()")
    public void beforePerformance() {
        duration = System.currentTimeMillis();
    }

    @After("pointCut()")
    public void afterPerformance(){
        duration = System.currentTimeMillis() - duration;
        System.out.println("La durée de la méthode est " + duration + " ms");
    }
}
