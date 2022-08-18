package com.server.openMedical.service.impl;


import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class Server1Service {

    public String getMsg(){
        BusinessService business = new BusinessService("Business");
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    }
}
