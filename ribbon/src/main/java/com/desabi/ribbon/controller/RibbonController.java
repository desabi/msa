package com.desabi.ribbon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    private static final Logger log = LoggerFactory.getLogger(RibbonController.class);

    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/index")
    public List<String> index() {
        ResponseEntity<String> forEntity = this.restTemplate.getForEntity("http://mongocruda/person/index", String.class);
        String forObject = this.restTemplate.getForObject("http://mongocruda/person/index", String.class);
        log.info("Uso de getForEntity: {}", forEntity);
        log.info("Uso de getForObject: {}", forObject);

        return Arrays.asList(forEntity.getBody(), forObject);
    }

}
