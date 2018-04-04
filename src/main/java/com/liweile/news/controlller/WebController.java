package com.liweile.news.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/index")
    public String helloHtml() {

        return "index";
    }


}
