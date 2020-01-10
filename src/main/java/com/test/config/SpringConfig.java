package com.test.config;

import com.test.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SpringConfig {

    @Autowired
    private MessageService messageService;

    @Scheduled(fixedDelay = 1000)
    public void setTime(){
        messageService.copy();
    }
}
