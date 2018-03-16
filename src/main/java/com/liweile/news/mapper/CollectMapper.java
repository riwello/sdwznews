package com.liweile.news.mapper;

import com.liweile.news.model.Collect;
import com.liweile.news.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CollectMapper {

    @Select("SELECT * FROM collect WHERE username = #{username}")
    List<Collect> selectByUsername(String username);

    @Select("SELECT * FROM collect WHERE username = #{arg0} and newsid = #{arg1}")
    Collect selectByUsernameAndNewsId(String username, int newsid);


    @Insert(value = "INSERT INTO collect(username,newsid) VALUES(#{username}, #{newsid})")
    int insert(Collect collect);

    @Delete("delete from collect WHERE username=#{arg0} and newsid=#{arg1}")
    void delete(String username, int  newsid);
}