package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.security.oauth2.jwt.Jwt;

import static org.springframework.http.HttpMethod.GET;

@RequiredArgsConstructor
@Log4j2
@RequestMapping("/client")
@RestController
public class KeycloakController {

    private final RestTemplate restTemplate;

    @GetMapping
    public String hello1(){
        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + jwt.getTokenValue());
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:8083/resource-server/resource1",
                GET,
                new HttpEntity<>(httpHeaders),
                String.class);

        log.info("response: " + exchange.getBody());
        return exchange.getBody();
    }

}
