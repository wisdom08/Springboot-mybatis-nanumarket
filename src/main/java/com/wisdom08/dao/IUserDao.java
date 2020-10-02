package com.wisdom08.dao;

import com.wisdom08.dto.User;

public interface IUserDao {
    User login(String id, String password);

    User findByEmail(String value);

    User join(String id, String email, String pw);
    User findById(String id);
}
