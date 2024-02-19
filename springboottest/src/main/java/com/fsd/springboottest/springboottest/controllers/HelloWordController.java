package com.fsd.springboottest.springboottest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test/")
public class HelloWordController {

    @GetMapping("helloworld")

    public String helloword(){
        return "Hello World !";
    }
}
