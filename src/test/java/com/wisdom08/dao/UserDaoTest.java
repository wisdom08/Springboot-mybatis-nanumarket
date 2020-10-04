package com.wisdom08.dao;

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
        "com.wisdom08.dao"
})
class UserDaoTest {


    @Autowired
    IUserDao userDao;

    @Test
    void test_존재하는_아이디로_로그인() {
        //assertEquals(1, 1);
        User user = userDao.login("a", "1111");
        assertNotNull(user);

        user = userDao.login("a ", "1111");
        assertNotNull(user);
    }


}