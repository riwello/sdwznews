package com.liweile.news.service.impl;

import com.github.pagehelper.PageHelper;
import com.liweile.news.mapper.NewsMapper;
import com.liweile.news.model.News;
import com.liweile.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsMapper newsMapper;

    @Override
    public ResponseEntity<List<News>> getNewsList(String type, int page, int size) {
        PageHelper.startPage(page, size);
        List<News> news = newsMapper.selectByType(type);

        return new ResponseEntity(news, HttpStatus.OK);
    }
}
