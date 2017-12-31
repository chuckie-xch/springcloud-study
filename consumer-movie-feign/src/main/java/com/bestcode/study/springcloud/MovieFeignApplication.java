package com.bestcode.study.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author xch
 * @create 2017-12-31 22:20
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MovieFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieFeignApplication.class);
    }
}
