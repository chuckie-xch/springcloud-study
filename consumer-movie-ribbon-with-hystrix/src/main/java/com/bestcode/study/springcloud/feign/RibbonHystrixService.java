package com.bestcode.study.springcloud.feign;

import com.bestcode.study.springcloud.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author xch
 * @create 2017-12-31 23:52
 **/
@Service
public class RibbonHystrixService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 通过id查询到的用户
     * 使用@HystrixCommand注解指定当该方法发生异常时调用的方法
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallback")
    public User findById(Long id) {
        return restTemplate.getForObject("http://provider-user/" + id, User.class);
    }

    public User fallback(Long id) {
        logger.info("发生异常，进入fallback方法，接受的参数是：id = {}", id);
        User user = new User();
        user.setId(-1L);
        user.setUsername("default username");
        user.setAge(0);
        return user;
    }

}
