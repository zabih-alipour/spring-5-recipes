package com.alipour.learn.chapter2.scenarios.concurrency;

import com.alipour.learn.chapter2.scenarios.LearningSubjectExecutor;
import com.alipour.learn.chapter2.scenarios.SUBJECT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.concurrent.*;

@Slf4j
public class ConcurrencyScenario extends LearningSubjectExecutor {
    public ConcurrencyScenario(ApplicationContext context) {
        super(context, SUBJECT.CONCURRENCY);
    }

    @Override
    protected void run() {
        TaskCollector collector = new TaskCollector();
        //--- Add son task to task collector
//        new Thread(() -> {
//            collector.push(String.format("Task NO: %s", ));
//        }).start();


        Runnable task = () -> {
            try {
                if (collector.pop() != null) {
                    log.info("It's look like a new task come to queue");
                    Thread.sleep(500);
                }else {
                    log.info("There is no task for execute");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info(Thread.currentThread().getName());
            log.info("Hello at {} \n", new Date());
        };

        try {
            ExecutorService cachedThreadPoolExecutorService =
                    Executors.newCachedThreadPool();
            if (cachedThreadPoolExecutorService.submit(task).get() == null)
                log.info("The cachedThreadPoolExecutorService "
                        + "has succeeded at {} \n", new Date());
            ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100);
            if (fixedThreadPool.submit(task).get() == null)
                log.info("The fixedThreadPool has " +
                                "succeeded at {} \n",
                        new Date());
            ExecutorService singleThreadExecutorService =
                    Executors.newSingleThreadExecutor();
            if (singleThreadExecutorService.submit(task).get() == null)
                log.info("The singleThreadExecutorService "
                        + "has succeeded at {} \n", new Date());
            ExecutorService es = Executors.newCachedThreadPool();

            if (es.submit(task, Boolean.TRUE).get().equals(Boolean.TRUE))
                log.info("Job has finished!");

            ScheduledExecutorService scheduledThreadExecutorService =
                    Executors.newScheduledThreadPool(10);
            if (scheduledThreadExecutorService.schedule(
                    task, 3, TimeUnit.SECONDS).get() == null)
                log.info("The scheduledThreadExecutorService "
                        + "has succeeded at {} \n", new Date());

            scheduledThreadExecutorService.scheduleAtFixedRate(task, 0, 5,
                    TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
