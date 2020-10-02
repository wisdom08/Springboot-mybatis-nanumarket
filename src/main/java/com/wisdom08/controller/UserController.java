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
}
