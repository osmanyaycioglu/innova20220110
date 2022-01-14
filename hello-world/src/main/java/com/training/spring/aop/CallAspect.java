package com.training.spring.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(name = "aspect.enabled", havingValue = "true", matchIfMissing = false)
@Component
@Aspect
public class CallAspect {

    @Before("execution(* com.training.spring.aop.Callee.*(..)) && args(name)")
    public void before(final JoinPoint jp,
                       final String name) {
        System.out.println(jp + " Before Callee " + name);
    }

    @After("execution(* com.training.spring.aop.Callee.*(..))")
    public void after() {
        System.out.println("After Callee");
    }

    @Around("execution(* com.training.spring.aop.Callee.*(..))")
    public Object around(final ProceedingJoinPoint pjp) {
        try {
            Object[] argsLoc = pjp.getArgs();
            Object[] newArgsLoc = new Object[1];
            newArgsLoc[0] = "ali";
            String nameLoc = pjp.getSignature()
                                .getName();
            long delta = System.nanoTime();
            Object proceedLoc = pjp.proceed(newArgsLoc);
            System.out.println(pjp.getSignature() + " Delta : " + (System.nanoTime() - delta));
            return (String) proceedLoc + " interpected";
        } catch (Throwable eLoc) {
            return null;
        }

    }

    @Around("within(com.training.spring..*) && @annotation(myIntercept)")
    public Object around(final ProceedingJoinPoint pjp,
                         final MyIntercept myIntercept) {
        try {
            long delta = System.nanoTime();
            Object proceedLoc = pjp.proceed();
            System.out.println("----"
                               + myIntercept.value()
                               + "----"
                               + pjp.getSignature()
                               + " Delta : "
                               + (System.nanoTime() - delta));
            return proceedLoc;
        } catch (Throwable eLoc) {
            return null;
        }

    }

}
