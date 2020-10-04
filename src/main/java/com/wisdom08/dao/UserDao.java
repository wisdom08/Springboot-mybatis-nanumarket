package com.wisdom08.dao;

import com.wisdom08.TypeMap;
import com.wisdom08.dto.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements IUserDao {

    //마이바티스 쿼리 관리
    @Autowired
    SqlSession session;

    @Override
    public User login(String id, String password) {

        TypeMap param = TypeMap.with("id", id.trim(), "password", password);

        //UserMapper.xml 파일에서 내가 실행할 sql 지정하기
        User user = session.selectOne("UserMapper.login", param);
        return user;
    }

    @Override
    public User findByEmail(String value) {
        return null;
    }

    @Override
    public User join(String id, String email, String pw) {
        return null;
    }

    @Override
    public User findById(String id) {
        return null;
    }
}
