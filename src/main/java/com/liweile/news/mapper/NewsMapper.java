package com.liweile.news.mapper;

import com.liweile.news.model.Collect;
import com.liweile.news.model.News;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NewsMapper {

    @Select("SELECT * FROM news WHERE type = #{type} order by time DESC")
    List<News> selectNews(String type);

    @Select("SELECT * FROM news WHERE title like CONCAT('%',#{word},'%')")
    List<News> searchNews(String word);

    @Select("SELECT content FROM news WHERE id = #{id}")
    String selectContent(int id);

    @Select("SELECT * FROM news WHERE id = #{id}")
    News selectbyId(int id);

    @Insert(value = "INSERT INTO news(title,content,time,type) VALUES(#{title}, #{content},#{time},#{type})")
    int  inser(News news);

    @Delete("delete from news where id = #{id}")
    int  delete(int id);

}