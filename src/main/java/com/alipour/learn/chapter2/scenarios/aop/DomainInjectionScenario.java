package com.alipour.learn.chapter2.scenarios.aop;

import com.alipour.learn.chapter2.models.aop.Complex2;
import com.alipour.learn.chapter2.scenarios.LearningSubjectExecutor;
import com.alipour.learn.chapter2.scenarios.SUBJECT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

@Slf4j
public class DomainInjectionScenario extends LearningSubjectExecutor {
    public DomainInjectionScenario(ApplicationContext context) {
        super(context, SUBJECT.DOMAIN_INJECTION);
    }

    @Override
    protected void run() {
        // FIXME: 12/31/2020 injection should be happen when domain initialize with new keyword: use weave
//        Complex2 complex2 = new Complex2(1, 4);
        Complex2 complex2 = context.getBean(Complex2.class);

        log.info("Complex format injected to domain model: {}", complex2);
    }
}
