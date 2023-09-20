package com.portfolio.camping.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @GetMapping("/search")
    public void camping_search(
            @RequestParam("camping_area")String area,
            @RequestParam(value="camping_type", required = false)String type,
            @RequestParam(value="camping_option", required = false)String option
            ){

    }

    @GetMapping("/result")
    private String search(Model model){

        return "pages/search/search_result";
    }

    @GetMapping("/camping")
    public String camping(Model model){

        return "pages/search/choice_camping";
    }

}
