package com.liweile.news.mapper;

import com.liweile.news.model.Collection;

import java.util.List;

public interface CollectMapper {

    List<Integer> getCollectList(String username);

    int addCollect(Collection collection);


}
