package com.wisdom08.controller;

import com.wisdom08.TypeMap;
import com.wisdom08.dto.User;
import com.wisdom08.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Object tryLogin(HttpSession session, @RequestParam String id, @RequestParam String password) {
        System.out.println("session = " + session);
        System.out.println("id = " + id);
        System.out.println("password = " + password);

        User user = userService.login(id, password);
        boolean success = user != null;
        if (success) {
            session.setAttribute("LOGIN_USER", user);
            return TypeMap.success("id", id, "nextUrl", "/");
        } else {
            return TypeMap.fail("cause", "LOGIN_REQUIRED");
        }

    }

    @PostMapping("/join")
    public Object tryJoin(@RequestParam String id, @RequestParam String email, @RequestParam String pw) {
        System.out.println("id = " + id);
        System.out.println("pw = " + pw);
        System.out.println("email = " + email);

        User user = userService.join(id, email, pw);
        boolean success = user != null;
        return TypeMap.success("id", id, "email", email, "pw", pw);

    }

    @PostMapping("/join/check/email")
    public Object checkDup(@RequestParam String value) {
        User user = userService.findUserByEmail(value);
        boolean dup = user != null;
        return TypeMap.success("dup", dup);
    }


    @PostMapping("/join/check/id")
    public Object checkId(@RequestParam String id) {
        User user = userService.FindUserById(id);
        boolean dup = user != null;
        return TypeMap.success("dup", dup);
    }
}
