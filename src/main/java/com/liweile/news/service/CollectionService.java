package com.liweile.news.service;

import com.liweile.news.model.Collection;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CollectionService {


    ResponseEntity<List<Collection>> getCollectListByUsername(String username);

    void addCollection(Collection collection);


}
