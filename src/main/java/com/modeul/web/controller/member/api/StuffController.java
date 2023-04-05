package com.modeul.web.controller.member.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("apiStuffController")
@RequestMapping("/api")
public class StuffController {
	
    @GetMapping("/hello")
    public String helloWorld() {
        return "hello!";
    }
}
