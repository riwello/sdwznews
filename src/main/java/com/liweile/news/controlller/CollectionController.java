package com.liweile.news.controlller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/collect")
@RestController
public class CollectionController {

    @RequestMapping("/add")
    public void addCollect(@RequestParam String username,@RequestParam String newsId){


    }

}
