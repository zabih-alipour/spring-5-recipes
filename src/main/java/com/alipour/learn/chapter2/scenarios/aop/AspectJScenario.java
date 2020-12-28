package com.alipour.learn.chapter2.scenarios.aop;

import com.alipour.learn.chapter2.aspects.ComplexCachingAspect;
import com.alipour.learn.chapter2.models.aop.*;
import com.alipour.learn.chapter2.scenarios.LearningSubjectExecutor;
import com.alipour.learn.chapter2.scenarios.SUBJECT;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.Aspects;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class AspectJScenario extends LearningSubjectExecutor {
    public AspectJScenario(ApplicationContext context) {
        super(context, SUBJECT.ASPECT);
    }

    @Override
    protected void run() {
        // FIXME: 12/28/20 aspect not work properly
        ComplexCachingAspect aspect = Aspects.aspectOf(ComplexCachingAspect.class);
        aspect.setCache(new ConcurrentHashMap<>());

        ComplexCalculator complexCalculator = context.getBean(ComplexCalculator.class);
        complexCalculator.add(new Complex(1, 2), new Complex(2, 3));
        complexCalculator.sub(new Complex(5, 8), new Complex(2, 3));
    }
}
