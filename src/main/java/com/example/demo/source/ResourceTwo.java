package com.example.demo.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.demo.singleton.Singleton;

@Service
@Scope("prototype")
public class ResourceTwo implements Runnable {

    private final Singleton singleton;

    @Autowired public ResourceTwo(final Singleton singleton) {

        this.singleton = singleton;
    }

    @Override
    public void run() {

        singleton.work(2, 3);
    }
}
