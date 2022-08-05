package com.example.firstspring.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping(value = "/by-name")
    public String hello(@RequestParam(value = "ism", required = true) String name,
                        @RequestParam Integer age){
        if (name.equals("Sardor"))
            return "Hello, the Sardor";

        return "Hello, " + name;
    }

    @PostMapping
    public String helloPost(){
        hello("", 1);
        return "hello post";
    }

}
