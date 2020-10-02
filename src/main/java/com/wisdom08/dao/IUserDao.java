package com.wisdom08.dao;

import com.wisdom08.dto.User;

public interface IUserDao {
    User login(String id, String password);
}
