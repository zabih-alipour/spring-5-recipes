package com.alipour.learn.chapter2.scenarios;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
@Slf4j
public abstract class LearningSubjectExecutor {
    protected final ApplicationContext context;
    protected final SUBJECT code;


    public LearningSubjectExecutor(ApplicationContext context, SUBJECT code) {
        this.context = context;
        this.code = code;
    }

    public void execute() {
        log.info(String.format("\n\n######################## %s ########################%n", code.name()));
        run();
    }

    protected abstract void run();

}
