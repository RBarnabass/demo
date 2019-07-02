package com.example.demo.configuration;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class RomeoBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private static AtomicInteger counter = new AtomicInteger();

    @Override
    public void postProcessBeanFactory(final ConfigurableListableBeanFactory beanFactory) throws BeansException {

        beanFactory.registerScope("romeo", new Romeo());
        System.out.println("Counter in bean pp - " + counter.incrementAndGet());
    }
}
