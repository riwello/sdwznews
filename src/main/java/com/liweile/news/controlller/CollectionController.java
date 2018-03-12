package com.liweile.news.controlller;


import com.liweile.news.model.Collect;
import com.liweile.news.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/collect")
@RestController
public class CollectionController {

    @Autowired
    CollectionService collectionService;

    @RequestMapping("/add")
    public void addCollect(@RequestParam String username,@RequestParam int  newsid){
        collectionService.addCollection(new Collect(username,newsid));

    }

}
