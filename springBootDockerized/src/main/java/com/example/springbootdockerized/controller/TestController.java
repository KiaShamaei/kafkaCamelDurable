package com.example.springbootdockerized.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/helloworld")
public class TestController {
    @GetMapping("/t")
    public String m1(){
        return "helloworld ...";
    }
}
