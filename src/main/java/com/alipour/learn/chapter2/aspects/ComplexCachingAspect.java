package com.alipour.learn.chapter2.aspects;

import com.alipour.learn.chapter2.models.aop.Complex;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * In this aspect, you cache the complex objects in a map with their real and imaginary values as
 * keys. Then, the most suitable time to look up the cache is when a complex object is created by invoking
 * the constructor. You use the AspectJ pointcut expression call to capture the join points of calling the
 * Complex(int,int) constructor.
 * Next, you need an around advice to alter the return value. If a complex object of the same value is
 * found in the cache, you return it to the caller directly. Otherwise, you proceed with the original constructor
 * invocation to create a new complex object. Before you return it to the caller, you cache it in the map for
 * subsequent usages.
 * The call pointcut is not supported by Spring AOP, so if you attempt to let Spring scan the pointcut
 * annotation, you’ll get the error “unsupported pointcut primitive call.”
 * Because this type of pointcut is not supported by Spring AOP, you have to use the AspectJ framework to
 * apply this aspect. The configuration of the AspectJ framework is done through a file named aop.xml in the
 * META-INF directory of the classpath root.
 */
@Aspect
@Slf4j
public class ComplexCachingAspect {
    private final Map<String, Complex> cache = new ConcurrentHashMap<>();

    public void setCache(Map<String, Complex> cache){
        this.cache.clear();
        this.cache.putAll(cache);
    }

    @Around("call(public com.alipour.learn.chapter2.models.aop.Complex.new(int, int)) $$ args(a,b)")
    public Object cacheAround(ProceedingJoinPoint joinPoint, int a, int b) throws Throwable {
        String key = a + "," + b;
        Complex complex = cache.get(key);
        if (complex == null) {
            log.warn("Cache MISS for (" + key + ")");
            complex = (Complex) joinPoint.proceed();
            cache.put(key, complex);
        } else {
            log.info("Cache HIT for (" + key + ")");
        }
        return complex;
    }
}
