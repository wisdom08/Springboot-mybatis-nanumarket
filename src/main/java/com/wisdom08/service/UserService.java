package com.wisdom08.service;

import com.wisdom08.dao.IUserDao;
import com.wisdom08.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    IUserDao userDao;

    public User login(String id, String password) {
        User user = userDao.login(id, password);
        if (user != null) {

        }
        return user;
    }

    public User join(String id, String email, String pw) {
        User user = userDao.join(id, email, pw);
        if (user != null) {

        }
        return user;
    }

    public User findUserByEmail(String value) {
        return userDao.findByEmail(value);
    }

    public User FindUserById(String id) {
        return userDao.findById(id);
    }


}
