package com.portfolio.camping.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final HttpSession httpSession;

    @GetMapping("/login")
    public String loginPage(){
        return "pages/login/login";
    }

    @GetMapping("/logout")
    public String logoutPage() {
        httpSession.removeAttribute("user");
        return "/";
    }

}
