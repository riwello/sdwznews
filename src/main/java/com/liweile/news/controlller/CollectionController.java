package com.liweile.news.controlller;


import com.liweile.news.model.Collect;
import com.liweile.news.model.News;
import com.liweile.news.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/collect")
@RestController
public class CollectionController {

    @Autowired
    CollectionService collectionService;

    @RequestMapping("/add")
    public void addCollect(@RequestParam String username,@RequestParam int  newsid){
        collectionService.addCollection(new Collect(username,newsid));

    }

    @RequestMapping("/collectList")
    public ResponseEntity<List<News>> getCollectNewsList(@RequestParam String username){
       return collectionService.getCollectListByUsername(username);

    }


    @RequestMapping("/getcollect")
    public ResponseEntity<Collect> getCollect(@RequestParam String username,@RequestParam int  newsid){
       return  collectionService.getCollect(username,newsid);

    }


    @RequestMapping("/delete")
    public void deleteCollect(@RequestParam String username,@RequestParam int  newsid){
        collectionService.deleteCollect(new Collect(username,newsid));
    }

}
