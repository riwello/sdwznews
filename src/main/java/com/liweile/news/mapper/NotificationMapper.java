package com.liweile.news.mapper;

import com.liweile.news.model.Notification;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NotificationMapper {

    @Select("SELECT * FROM notify")
    List<Notification> selectAll();


    @Insert(value = "INSERT INTO notify(username,time,content) VALUES(#{username}, #{time},#{content})")
    int  insert(Notification notification);


    @Delete("delete from notify where id = #{id}")
    int  delete(int id);
}
