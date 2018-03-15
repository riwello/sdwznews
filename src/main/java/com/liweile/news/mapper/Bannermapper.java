package com.liweile.news.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Bannermapper {

    @Select("SELECT url FROM banner ")
    List<String> selectBanner();
}
