package com.example.demo.singleton;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("romeo")
public class SingletonImpl implements Singleton {

    private int result;

    @Override
    public  int work(final int a, final int b) {

        for (int i = 0; i < 100000; i++) {

            result = a + b;
            result = result - a;
            result = result + a;
            result = result - b;
            result = result + b;
        }

        System.out.println(" === " + result + " ****** " + LocalDateTime.now() + " ------------------- " + Thread.currentThread().getName());
        return result;
    }
}
