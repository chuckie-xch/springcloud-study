package com.bestcode.study.springcloud.feign;

import com.bestcode.study.springcloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * provider-user1置为无效，使用熔断器版本UserFeignHystrixClient
 * @author xch
 * @create 2017-12-31 22:23
 **/
//@FeignClient(name = "provider-user")
@FeignClient(name = "provider-user1")
public interface UserFeignClient {

    @RequestMapping("/{id}")
    public User findByIdFeign(@RequestParam("id") Long id);

}
