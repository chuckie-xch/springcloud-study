package com.bestcode.study.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author xch
 * @create 2017-12-31 21:27
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MovieRibbonApplication {

    /**
     * 实例化RestTemplate,并注入到Spring容器中，
     * 通过@LoadBalanced注解开启负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(MovieRibbonApplication.class);
    }
}
