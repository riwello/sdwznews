package com.liweile.news.service.impl;

import com.liweile.news.mapper.CollectMapper;
import com.liweile.news.model.Collect;

import com.liweile.news.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    CollectMapper collectMapper;


    @Override
    public ResponseEntity<List<Collect>> getCollectListByUsername(String username) {
        List<Collect> collectList = new ArrayList<>();


        return new ResponseEntity(collectList, HttpStatus.OK);
    }

    @Override
    public void addCollection(Collect collection) {
        List<Collect> collects = collectMapper.selectByUsernameAndNewsId(collection.getUsername(), collection.getNewsid());


        if (collects == null || collects.size() == 0)
            collectMapper.insert(collection);


    }
}
