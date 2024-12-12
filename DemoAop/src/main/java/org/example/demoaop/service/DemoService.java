package org.example.demoaop.service;

import org.example.demoaop.annotation.AroundAnnotation;
import org.example.demoaop.annotation.ExceptionAnnotation;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public void method() {
        System.out.println("mon application métier");
    }

    public String methodWithResult() {
        return "result";
    }

//    @AroundAnnotation
    @ExceptionAnnotation
    public void methodThrow(int arg, String arg2) {
        throw new RuntimeException("exception from MethodThrow");
    }
}
