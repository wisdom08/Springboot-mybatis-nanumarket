package com.wisdom08.dao;

import com.wisdom08.dto.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeUserDao implements IUserDao {

    private List<User> fakeUsers;

    public FakeUserDao() {
        fakeUsers = new ArrayList<>();
        fakeUsers.add(new User(100L, "a", "a@naver.com", "1234"));
    }

    @Override
    public User login(String id, String password) {
        for (User user : fakeUsers) {
            if (user.getId().equals(id) && user.getPassword().equals(password)) {
                return user;
            }
        }
            return null;
    }


}
