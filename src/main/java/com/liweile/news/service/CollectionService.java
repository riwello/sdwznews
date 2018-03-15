package com.liweile.news.service;

import com.liweile.news.model.Collect;
import com.liweile.news.model.News;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CollectionService {


    ResponseEntity<List<News>> getCollectListByUsername(String username);

    void addCollection(Collect collection);


    ResponseEntity getCollect(String username, int newsid);

    void deleteCollect(Collect collect);
}
