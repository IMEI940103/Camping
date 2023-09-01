package com.portfolio.camping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {

    @GetMapping("/result")
    public String search(Model model){

        return "pages/search/search_result";
    }

    @GetMapping("/camping")
    public String camping(Model model){

        return "pages/search/choice_camping";
    }

}
