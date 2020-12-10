package com.alipour.learn.chapter2.scenarios;


import org.springframework.context.ApplicationContext;

public abstract class LearningSubjectExecutor {
    protected final ApplicationContext context;
    protected final SUBJECT code;


    public LearningSubjectExecutor(ApplicationContext context, SUBJECT code) {
        this.context = context;
        this.code = code;
    }

    public void execute() {
        System.out.printf("\n\n######################## %s ########################%n", code.name());
        run();
    }

    protected abstract void run();

}
