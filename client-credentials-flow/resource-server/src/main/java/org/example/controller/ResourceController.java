package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/resource-server")
@RestController
public class ResourceController {

    @GetMapping("/resource1")
    public String resource1(){
        return "resource server - resource1";
    }

    @GetMapping("/resource2")
    public String resource2(){
        return "resource server - resource2";
    }
}
