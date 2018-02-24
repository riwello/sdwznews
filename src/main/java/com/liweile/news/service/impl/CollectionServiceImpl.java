package com.liweile.news.service.impl;

import com.liweile.news.mapper.CollectMapper;
import com.liweile.news.model.Collection;
import com.liweile.news.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CollectionServiceImpl implements CollectionService {

    @Autowired
    CollectMapper collectMapper;


    @Override
    public ResponseEntity<List<Collection>> getCollectListByUsername(String username) {
        List<Integer> collectList = collectMapper.getCollectList(username);


        return new ResponseEntity(collectList, HttpStatus.OK);
    }

    @Override
    public void addCollection(Collection collection) {
        collectMapper.addCollect(collection);


    }
}
