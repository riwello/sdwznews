package com.liweile.news.mapper;

import com.liweile.news.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    @Insert(value = "INSERT INTO user(username,password,department,name,age,classname) VALUES(#{username}, #{password}, #{department}, #{name},#{age},#{classname})")
    int insert(User user);

    @Select("SELECT * FROM user WHERE username = #{username}")
    User selectByUsername(String username);

    @Select("SELECT * FROM user")
    List<User> selectAll();

    @Update("update user set classname =#{arg0} where username =#{arg1}")
    void updateClassName(String classname,String username);

    @Update("update user set name =#{arg0} where username =#{arg1}")
    void updateName(String name,String username );
}