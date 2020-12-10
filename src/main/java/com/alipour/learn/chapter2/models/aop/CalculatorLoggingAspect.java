package com.alipour.learn.chapter2.models.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Slf4j
@Component
public class CalculatorLoggingAspect {
    //-- Only for a particular method
    @Before("execution(* ArithmeticCalculator.add(..))")
    public void add() {
        log.info("@Before >> The method add called from class ArithmeticCalculator.");
    }

    //-- Only for a particular method
    @After("execution(* ArithmeticCalculator.*(..))")
    public void after(JoinPoint joinPoint) {
        log.info(String.format("@After >> The method %s() called from class %s.", joinPoint.getSignature().getName(),
                joinPoint.getTarget().getClass().getSimpleName()));
    }

    //-- AfterReturn each method of a particular class for execute on all classes just put * instead of ArithmeticCalculator
    @AfterReturning(value = "execution(* ArithmeticCalculator.*(..))", returning = "result")
    public void logAfterExecutionMethod(JoinPoint joinPoint, double result) {
        log.info(String.format("@AfterReturning >> The method %s() with parameter %f, %f returned %f.",
                joinPoint.getSignature().getName(),
                joinPoint.getArgs()[0],
                joinPoint.getArgs()[1],
                result));
    }

    //-- AfterThrowing each method exceptions
    @AfterThrowing(value = "execution(* ArithmeticCalculator.*(..))", throwing = "e")
    public void afterThrow(JoinPoint joinPoint, Throwable e) {
        log.info(String.format("@AfterThrowing >> Exception %s occured in The method %s() at class %s.",
                e.getMessage(),
                joinPoint.getSignature().getName(),
                joinPoint.getTarget().getClass().getSimpleName()));
    }

    //-- Only for a particular method
    @Around("execution(* UnitCalculator.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("@Around >> The method {}() begins with {} at class {}.",
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()),
                joinPoint.getTarget().getClass().getSimpleName());

        Object result = null;
        try {
            result = joinPoint.proceed();
            log.info("The method {}() ends with {}.", joinPoint.getSignature().getName(), result);
        } catch (Exception e) {
            log.error("Illegal argument {} in {}()",
                    Arrays.toString(joinPoint.getArgs()),
                    joinPoint.getSignature().getName());
        }
        return result;
    }
}
