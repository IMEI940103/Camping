package com.portfolio.camping.api.controller;

import com.portfolio.camping.api.service.ImportSQL;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final ImportSQL importSQL;
    boolean sql = true;

    @GetMapping(value = {"/","index","/index"})
    public String indexController(){

        if(sql){
            importSQL.init_insert_campinginfo();
            importSQL.init_insert_room();
            sql = false;
        }

        return "pages/index";

    }

}
