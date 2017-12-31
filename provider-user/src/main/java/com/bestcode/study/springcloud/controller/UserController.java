package com.bestcode.study.springcloud.controller;

import com.bestcode.study.springcloud.dao.UserRepository;
import com.bestcode.study.springcloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xch
 * @create 2017-12-31 20:49
 **/
@RestController
public class UserController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private UserRepository userRepository;

    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        User user = userRepository.findOne(id);
        return user;
    }

    /**
     * 本地服务实例信息
     * @return
     */
    @GetMapping("/instance-info")
    public ServiceInstance showInfo() {
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        return serviceInstance;
    }


}
