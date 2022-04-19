package com.desabi.ribbon.controller;

import com.desabi.ribbon.config.RibbonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/index")
    public ResponseEntity<String> index() {
        return this.restTemplate.getForObject("http://mongocruda/person/index", ResponseEntity.class);
    }

}
