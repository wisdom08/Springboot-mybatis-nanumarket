package com.wisdom08.dao;

import com.wisdom08.dto.User;

public interface IUserDao {
    User login(String id, String password);

    User findByEmail(String value);

    User findById(String id);

    /**
     * 회원 가입
     * @param user
     * @return
     */
    User join(User user);

    User findBySeq(Long sellerSeq);
}
