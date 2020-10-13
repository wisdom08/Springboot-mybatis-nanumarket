package com.wisdom08.dao;

import com.wisdom08.TypeMap;
import com.wisdom08.dto.User;
import org.apache.ibatis.annotations.Param;
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
        //TODO ID가 ID일 수도 있고, eamil일수도 있음
        TypeMap param = TypeMap.with("id", id.trim(), "password", password);

        //UserMapper.xml 파일에서 내가 실행할 sql 지정하기
        User user = session.selectOne("UserMapper.login", param);
        System.out.println("[LOGIN] "+user);
        return user;
    }

    @Override
    public User findByEmail(String value) {
        //TODO 이메일로 사용자 찾는 구현


        return null;
    }


    @Override
    public User join(User user) {
        /* INSERT, UPDATE, DELETE
        * session.insert();
        * session.update();
        * session.delete();
        * */
        int cnt = session.insert("UserMapper.join", user);

     /*   if (cnt != 1) {
            // error !!
        }*/

        return user;
    }

    @Override
    public User findBySeq(Long userSeq) {
       return session.selectOne("UserMapper.findBySeq", userSeq);
    }

    @Override
    public User findById(String id) {
        //TODO 아이디로 사용자 찾는 구현

        User o = session.selectOne("UserMapper.findById", id);
        
        if (o == null) {
            System.out.println("없는 아이디다");
        } else {
            System.out.println("중복된 아이디다");
        }
        
        
        return o;
    }
}
