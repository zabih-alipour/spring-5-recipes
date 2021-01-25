package com.alipour.learn.chapter2.scenarios.concurrency;

import java.util.concurrent.ConcurrentLinkedQueue;

public class TaskCollector {
    private final ConcurrentLinkedQueue<String> tasks = new ConcurrentLinkedQueue<>();

    public void push(String taskName) {
        tasks.add(taskName);
    }

    public String pop() {
        return tasks.poll();
    }
}
