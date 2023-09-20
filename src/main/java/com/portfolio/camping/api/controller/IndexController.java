package com.portfolio.camping.api.controller;

import com.portfolio.camping.api.service.ImportSQL;
import com.portfolio.camping.user.entity.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final ImportSQL importSQL;
    boolean sql = true;

    private final HttpSession httpSession;

    @GetMapping(value = {"/","index","/index"})
    public String indexController(Model model){

        if(sql){
            importSQL.init_insert_campinginfo();
            importSQL.init_insert_room();
            sql = false;
        }

        //model.addAttribute("posts",postsService.findAllDesc());
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null){
            model.addAttribute("userName",user.getUserName());
        }

        return "pages/index";

    }

}
