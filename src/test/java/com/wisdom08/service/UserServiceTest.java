package com.wisdom08.service;

import com.wisdom08.dto.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.ComponentScan;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackages = {
        "com.wisdom08.service",
        "com.wisdom08.dao"
})
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void test_존재하는_아이디로_로그인() {
        User user = userService.login("a", "1111");
        assertNotNull(user);

    }

}