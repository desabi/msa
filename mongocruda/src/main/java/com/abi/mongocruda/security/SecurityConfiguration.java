package com.abi.mongocruda.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String PERSON_URL = "/person";
    private static final String PERSON_ID_URL = "/person/{id}";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/person/index").permitAll()
                .antMatchers(HttpMethod.POST, PERSON_URL).permitAll() // create
                .antMatchers(HttpMethod.GET, PERSON_URL).permitAll() // read
                .antMatchers(HttpMethod.GET, PERSON_ID_URL).permitAll() // read by id
                .antMatchers(HttpMethod.PUT, PERSON_ID_URL).permitAll() // update
                .antMatchers(HttpMethod.DELETE, PERSON_ID_URL).permitAll() // delete by id
                .anyRequest().authenticated();
    }
}
