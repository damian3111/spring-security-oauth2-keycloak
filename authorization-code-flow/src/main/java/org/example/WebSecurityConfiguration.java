package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfiguration {

    @Order(1)
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/v1/keycloak/hello1", "/oauth2/**", "/login/oauth2/**")
       .authorizeHttpRequests(r -> r.anyRequest().authenticated())
       .oauth2Login(Customizer.withDefaults());

        return http.build();
    }

    @Order(2)
    @Bean
    public SecurityFilterChain resourceFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/v1/keycloak/hello2")
                .authorizeHttpRequests(r -> r.anyRequest().authenticated())
                .oauth2ResourceServer(config -> config.jwt(Customizer.withDefaults()));

        return http.build();
    }
}
