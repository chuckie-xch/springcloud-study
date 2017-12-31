package com.bestcode.study.springcloud.controller;

import com.bestcode.study.springcloud.entity.User;
import com.bestcode.study.springcloud.feign.UserFeignClient;
import com.bestcode.study.springcloud.feign.UserFeignHystrixClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xch
 * @create 2017-12-31 22:30
 **/
@RestController
public class FeignController {

//    @Autowired
//    private UserFeignClient userFeignClient;

    @Autowired
    private UserFeignHystrixClient userFeignHystrixClient;

    @GetMapping("feign/{id}")
    public User findByIdFeign(@PathVariable Long id) {
        User user = userFeignHystrixClient.findByIdFeign(id);
        return user;
    }
}
