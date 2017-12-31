package com.bestcode.study.springcloud.dao;

import com.bestcode.study.springcloud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xch
 * @create 2017-12-31 20:49
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
