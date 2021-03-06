package com.liweile.news.service;

import com.liweile.news.model.News;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NewsService {


    ResponseEntity<List<News>> getNewsList(String type,int page,int size);

    ResponseEntity<List<News>> serachNews(String word, int page, int size);

    ResponseEntity<String >  getConetnt(int id);

    ResponseEntity<List<String>> getBanner();

    ResponseEntity addNews(News news);

    ResponseEntity deleteNews(int id);
}
