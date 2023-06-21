package org.example.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Log4j2
@RequestMapping("/v1/keycloak")
@RestController
public class KeycloakController {

    @GetMapping("/hello1")
    public String hello1(){

        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        log.info(authorities);

        return "hello world";
    }

    @GetMapping("/hello2")
    public String hello2(){
        return "hello world2";
    }
}
