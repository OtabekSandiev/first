package com.example.firstspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InController {

    @GetMapping("/hello-page")
    public String hello(){
        return "index.html";
    }
}
