package com.test.controller;

import com.test.model.Message;
import com.test.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    private final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @PostMapping
    public  ResponseEntity save(@RequestBody Message message) {
        messageService.save(message);
        //logger.info("fffff");
        return ResponseEntity.ok().build();
    }
}
