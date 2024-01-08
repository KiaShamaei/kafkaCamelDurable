package org.example.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ControllerTest {
    @Autowired
    ProducerTemplate producerTemplate;
    @GetMapping("/{id}")
    public String m1(@PathVariable String id){
        producerTemplate.asyncSendBody("direct:topic1", "My Event from controller " + id);
//        producerTemplate.sendBody("direct:topic1", "My Event");
        return " test api read... " + id;
    }
}
