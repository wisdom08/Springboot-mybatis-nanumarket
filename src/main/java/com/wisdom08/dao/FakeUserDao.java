package com.wisdom08.dao;

import com.wisdom08.dto.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class FakeUserDao  {

    private List<User> fakeUsers;

    public FakeUserDao() {
        fakeUsers = new ArrayList<>();
        fakeUsers.add(new User(100L, "a", "a@naver.com", "1234"));
    }


    public User login(String id, String password) {
        for(User user: fakeUsers) {
            if (user.getId().equals(id) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public User findByEmail(String value) {
        for (User user : fakeUsers) {
            if (user.getEmail().equals(value)) {
                return user;
            }
        }
        return null;
    }

    public User join(String id, String email, String pw) {
        for (User user : fakeUsers) {
            if (user.getId().equals(id) && user.getPassword().equals(pw)) {
                return user;
            }
        }
        return null;
    }

    public User findById(String id) {
        for (User user : fakeUsers) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }


}
