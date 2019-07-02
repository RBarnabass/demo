package com.example.demo.pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import com.example.demo.source.Resource;
import com.example.demo.source.ResourceTwo;

@Service
public class Test implements Tester {

    @Autowired private TaskExecutor taskExecutor;
    @Autowired private ApplicationContext applicationContext;

    @Override
    public void act() {

        for (int i = 0; i < 200; i++) {

            if (i % 2 == 0) {
                executeAsynchronously(true);
            } else {
                executeAsynchronously(false);
            }
        }
    }

    private void executeAsynchronously(boolean mark) {

        if (mark) {
            Resource resource = applicationContext.getBean(Resource.class);
            taskExecutor.execute(resource);
        } else {
            ResourceTwo resourceTwo = applicationContext.getBean(ResourceTwo.class);
            taskExecutor.execute(resourceTwo);
        }
    }
}
