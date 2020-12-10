package com.alipour.learn.chapter2.scenarios;

import com.alipour.learn.chapter2.components.AuditCheckBeanPostProcessor;
import org.springframework.context.ApplicationContext;

public class BeanPostProcessorScenario extends LearningSubjectExecutor {
    public BeanPostProcessorScenario(ApplicationContext context) {
        super(context, SUBJECT.BEAN_POST_PROCESSOR);
    }

    @Override
    protected void run() {
        //-- It working at starting application in other words on startup
        System.out.printf("Bean %s implemented postprocessor logic.\n", AuditCheckBeanPostProcessor.class.getSimpleName());
        System.out.printf("Check output if you can see AppConfig log like %s then it work property.", "postProcess");
    }
}
