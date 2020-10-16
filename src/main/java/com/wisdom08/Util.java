package com.wisdom08;

import com.wisdom08.dto.User;

import javax.servlet.http.HttpSession;



public class Util {

    public static User getUser(HttpSession session) {
        return (User) session.getAttribute("LOGIN_USER");
    }

    public static void saveUser(HttpSession session, User user) {
        session.setAttribute("LOGIN_USER", user);
    }
}
