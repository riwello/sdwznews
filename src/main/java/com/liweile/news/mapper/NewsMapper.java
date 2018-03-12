package com.liweile.news.mapper;

import com.liweile.news.model.News;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NewsMapper {

    @Select("SELECT * FROM news WHERE type = #{type}")
    List<News> selectNews(String type);

    @Select("SELECT * FROM news WHERE title like CONCAT('%',#{word},'%')")
    List<News> searchNews(String word);

    @Select("SELECT content FROM news WHERE id = #{id}")
    String selectContent(int id);


}