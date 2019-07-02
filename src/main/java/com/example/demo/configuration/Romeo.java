package com.example.demo.configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class Romeo implements Scope {

    private Map<String, Object> scopedObjects = Collections.synchronizedMap(new HashMap<>());
    private Map<String, Runnable> destructionCallbacks = Collections.synchronizedMap(new HashMap<>());

    private static AtomicInteger counter = new AtomicInteger();

    @Override
    public Object get(final String name, final ObjectFactory<?> objectFactory) {

        /*if (!scopedObjects.containsKey(name)) {
            scopedObjects.put(name, objectFactory.getObject());
        }

        return scopedObjects.get(name);*/

        System.out.println("Counter in scope - " + counter.incrementAndGet());
        return objectFactory.getObject();
    }

    @Override
    public Object remove(final String name) {

        destructionCallbacks.remove(name);
        return scopedObjects.remove(name);
    }

    @Override
    public void registerDestructionCallback(final String name, final Runnable callback) {

        destructionCallbacks.put(name, callback);
    }

    @Override
    public Object resolveContextualObject(final String key) {

        return null;
    }

    @Override
    public String getConversationId() {

        return "romeo";
    }

}
