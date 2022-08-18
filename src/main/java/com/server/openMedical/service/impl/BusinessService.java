package com.server.openMedical.service.impl;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class BusinessService implements Callable<String> {
    private String name;

    public BusinessService(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        return name;
    }
}
