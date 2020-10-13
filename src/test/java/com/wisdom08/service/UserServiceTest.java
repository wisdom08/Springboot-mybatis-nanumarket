package com.wisdom08.service;

import com.wisdom08.NanumarketException;
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

    @Test
    void test_짧은비번으로_가입시도() {
        User user = new User("a", "a@naver.com", "33");
        assertThrows(NanumarketException.class, () -> {
            userService.join(user);
        });

    }

    @Test
    void test_중복이메일() {
        //TODO 중복 이메일
        User user1 = new User("a", "a@naver.com", "33");
        User user2 = new User("b", "a@naver.com", "11");
        user1.setEmail("a@naver.com");
        user2.setEmail("a@naver.com");

        userService.join(user1);
        userService.join(user2);

        fail("여기까지 실행되면 안된다. 위에서 예외가 나와야 한다.");
    }

    @Test
    void test_중복아이디() {
        //TODO 중복 아이디 실패해야 함
        User user = new User("a", "a@naver.com", "33");
    }


}