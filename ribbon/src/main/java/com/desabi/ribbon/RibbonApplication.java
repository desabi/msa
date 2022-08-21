package com.desabi.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RibbonClient(name = "mongocruda")

// No instances available for mongocruda
// @RibbonClient(name = "mongocruda", configuration = RibbonConfig.class)
public class RibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
