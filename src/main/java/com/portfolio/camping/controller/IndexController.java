package com.portfolio.camping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = {"/","index","/index"})
    public String indexController(){
        return "pages/index";
    }

}
