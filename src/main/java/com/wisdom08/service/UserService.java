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

}
