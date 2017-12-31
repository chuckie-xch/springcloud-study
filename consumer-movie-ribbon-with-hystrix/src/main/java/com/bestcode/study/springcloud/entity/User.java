package com.bestcode.study.springcloud.entity;

/**
 * @author xch
 * @create 2017-12-31 23:43
 **/
public class User {
    private Long id;
    private String username;
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
