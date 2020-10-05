package com.wisdom08.dao;

import com.wisdom08.dto.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

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


    @Test
    @Transactional // insert 된 거 무시한다. rollback
    void test_회원가입() {
        User user;
        user = userDao.login("123a", "1111");
        System.out.println("회원가입 전" + user);
        assertNull(user);
        
        user = new User("123a", "123a@a.com", "1111");
        userDao.join(user); //test 끝나면 insert 된 거 취소시킨다.  //시퀀스 할당 후 rollback 되어서 버려진다.

        user= userDao.login(user.getId(), user.getPassword());
        System.out.println("회원가입 후"+user);
        assertNotNull(user);
    }
}