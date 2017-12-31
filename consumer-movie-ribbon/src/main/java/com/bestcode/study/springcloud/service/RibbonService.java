package com.bestcode.study.springcloud.service;

import com.bestcode.study.springcloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author xch
 * @create 2017-12-31 21:34
 **/
@Service
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    public User findById(Long id) {
        //  http://服务提供者的serviceId/url
        return this.restTemplate.getForObject("http://provider-user/" + id, User.class);
    }
}
