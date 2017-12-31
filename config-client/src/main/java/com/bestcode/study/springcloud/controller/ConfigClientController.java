package com.bestcode.study.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RefreshScope注解不能少，否则即使使用/refresh,配置也不会刷新
 * @author xch
 * @create 2018-01-01 1:11
 **/
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${profile}")
    private String profile;

    @GetMapping("/hello")
    public String hello() {
        return profile;
    }
}
