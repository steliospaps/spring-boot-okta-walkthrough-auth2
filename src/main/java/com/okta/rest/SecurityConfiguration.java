

package com.okta.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
      http
          .csrf().disable() //
          .authorizeHttpRequests((requests) -> requests//
              .requestMatchers(HttpMethod.OPTIONS).permitAll() // allow CORS option calls for Swagger UI
              .requestMatchers("/openapi/openapi.yml").permitAll() //
              .anyRequest().authenticated()) //
          .httpBasic();
      return http.build();
    }}

