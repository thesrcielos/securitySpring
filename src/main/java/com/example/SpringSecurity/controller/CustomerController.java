package com.example.SpringSecurity.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class CustomerController {

    @GetMapping("/index")
    public String index(){
        return "Hello world!";
    }

    @GetMapping("/index2")
    public String index2(){
        return "Hello world not secured!";
    }
}
