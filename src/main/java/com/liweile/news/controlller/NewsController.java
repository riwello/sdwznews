package com.liweile.news.controlller;

import com.liweile.news.model.News;
import com.liweile.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {


    @Autowired
    NewsService newsService;

    @RequestMapping("/list")
    public ResponseEntity<List<News>> getNewsList(@RequestParam int page, @RequestParam int size, @RequestParam String type) {

        return newsService.getNewsList(type, page, size);
    }


    @RequestMapping("/search")
    public ResponseEntity<List<News>> serachNews(@RequestParam int page, @RequestParam int size, @RequestParam String word) {

        return newsService.serachNews(word, page, size);
    }

    @RequestMapping("/details")
    public ResponseEntity<String> getContent(@RequestParam int id) {

        return newsService.getConetnt(id);
    }

    ;

}
