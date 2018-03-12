package com.liweile.news.service;

import com.liweile.news.model.Collect;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CollectionService {


    ResponseEntity<List<Collect>> getCollectListByUsername(String username);

    void addCollection(Collect collection);


}
