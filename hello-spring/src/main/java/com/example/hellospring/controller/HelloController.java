package com.example.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Spring");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String hello(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-mvc";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name, Model model) {
        return "hello " + name;
    }
}
