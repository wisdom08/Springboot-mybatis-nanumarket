package com.wisdom08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String pageLogin() {
        return "page-login";
    }

    @GetMapping("/market/write")
    public String pageWrite() {
        return "/market/page-write";
    }
}
