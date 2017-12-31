package com.bestcode.study.springcloud.feign;

import com.bestcode.study.springcloud.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xch
 * @create 2018-01-01 0:21
 **/
@FeignClient(name = "provider-user", fallback = UserFeignHystrixClient.HystrixClientFallback.class)
public interface UserFeignHystrixClient {

    @RequestMapping("/{id}")
    public User findByIdFeign(@RequestParam("id") Long id);

    @Component
    static class HystrixClientFallback implements UserFeignHystrixClient {

        private static final Logger logger = LoggerFactory.getLogger(HystrixClientFallback.class);

        @Override
        public User findByIdFeign(Long id) {
            logger.info("发生异常，进入fallback方法，接受的参数：id = {}", id);
            User user = new User();
            user.setId(-1L);
            user.setUsername("default username");
            user.setAge(0);
            return user;
        }
    }
}
