package com.abi.mongocruda.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public ResponseEntity<String> index() {
        String message = "Service Person working on port: " + port;
        log.info(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
