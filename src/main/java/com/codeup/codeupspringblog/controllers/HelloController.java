package com.codeup.codeupspringblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
//
//    /hello -> Hello world!
//    /hello?name=bob -> Hello bob!
//    /hello/bob -> Hello bob!
    @GetMapping("/hello")
    @ResponseBody
    public String sayHello(@RequestParam String name){
        return "<h1>Hello " + name + "!</h1>";
    }

    @GetMapping("/hello/{personName}")
    @ResponseBody
    public String sayHelloName(@RequestParam String personName){
        if(personName == null) {
            personName = "world";
        }
        return "<h1>Hello " + personName + "!</h1>";
    }
}