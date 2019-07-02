package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pack.Tester;

@RestController
@RequestMapping("/test")
public class Controller {

    @Autowired private Tester tester;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public void start() {

        long start = System.currentTimeMillis();
        tester.act();
        long end = System.currentTimeMillis();

        System.out.println(end-start);
    }

}
