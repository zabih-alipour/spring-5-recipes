package com.alipour.learn.chapter2.scenarios.aop;

import com.alipour.learn.chapter2.models.aop.ArithmeticCalculator;
import com.alipour.learn.chapter2.models.aop.UnitCalculator;
import com.alipour.learn.chapter2.scenarios.LearningSubjectExecutor;
import com.alipour.learn.chapter2.scenarios.SUBJECT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

@Slf4j
public class AOPScenario extends LearningSubjectExecutor {
    public AOPScenario(ApplicationContext context) {
        super(context, SUBJECT.BEAN_POST_PROCESSOR);
    }

    @Override
    protected void run() {
        log.info("For AOP we need @Aspect annotation to annotate a class with it.");
        log.info("Then we need to enable aspect by annotating spring application with @EnableAspectJAutoProxy");
        log.info("Also we need to add aspect dependency to application library");
        log.info("AOP support four type aspect: @Before, @After, @AfterReturning, @AfterThrowing, and @Around");
        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \n");
        ArithmeticCalculator arithmeticCalculator = context.getBean(ArithmeticCalculator.class);
        arithmeticCalculator.add(1, 2);
        arithmeticCalculator.sub(4, 3);
        arithmeticCalculator.mul(2, 3);
        arithmeticCalculator.div(4, 2);
        arithmeticCalculator.throwException(4, 2);

        UnitCalculator unitCalculator = context.getBean(UnitCalculator.class);
        unitCalculator.kilogramToPound(10);
        unitCalculator.kilometerToMile(5);
    }
}
