package com.bestcode.study.springcloud.controller;

import com.bestcode.study.springcloud.entity.User;
import com.bestcode.study.springcloud.feign.RibbonHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xch
 * @create 2018-01-01 0:03
 **/
@RestController
public class RibbonHystrixController {

    @Autowired
    private RibbonHystrixService ribbonHystrixService;

    @GetMapping("/ribbon/{id}")
    public User findById(@PathVariable Long id) {
        return ribbonHystrixService.findById(id);
    }
}
