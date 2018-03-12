package com.liweile.news.mapper;

import com.liweile.news.model.Collect;
import com.liweile.news.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CollectMapper {

    @Select("SELECT * FROM colect WHERE username = #{username}")
    List<Collect> selectByUsername(String username);

   @Select("SELECT * FROM colect WHERE username = #{username} and newsid = #{newsid}")
    List<Collect> selectByUsernameAndNewsId(String username,int newsid);



    @Insert(value = "INSERT INTO collect(username,newsid) VALUES(#{username}, #{newsid})")
    int  insert(Collect collect);


}